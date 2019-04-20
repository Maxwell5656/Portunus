/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.DECRYPT_MODE;
import javax.crypto.KeyGenerator;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Maxwell
 */
public class Storage {
    //TODO: Make Storage Class
    //I had a lot of help from this site when coding this class https://howtodoinjava.com/security/java-aes-encryption-example/
    private final Path storageFilePath; //this tells how the class will get to the file.
    private static final int SIZE = 10; //This will be the size of the Hash Table.
    private ConcurrentHashMap hashTable;
    private Cipher cipher;
    private SecretKeySpec key;
    private byte[] keyGen; // this is a test value for now.
    
    private ArrayList<Observer> observers;
    private StorageEvent lastEvent;
    
    public Storage(String fileName, String key)
    // Note this is designed for files stored in User.dir. This location can be found in Help->About in Netbeans -Maxwell
    {
        String fileLocation = System.getProperty("user.dir") + "\\" + fileName;
        storageFilePath = Paths.get(fileLocation); // tracks the location of this file
        hashTable = HashingFunction.createTable();
        this.observers = new ArrayList<>();
        try
        {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }
        catch(Exception e)
        {
            System.out.println("Error: Portunus could not find the required encryption algorithm. See Storage.java.");
            e.printStackTrace(System.out);
        }
       
        // Cipher will use Advanced Encryption System
        this.setKey(key);
        this.loadAllData();
    }
    private void setKey(String toKey)
    {
        keyGen = null;
        MessageDigest sha = null;
        try
        {
            keyGen = toKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            keyGen = sha.digest(keyGen);
            keyGen = Arrays.copyOf(keyGen, 16);
            key = new SecretKeySpec(keyGen, "AES"); 
        }
        catch(Exception e)
        {
            System.out.println("KEY SCREW UP");
        }
    }
    public void setData(String newLine)
    // Adds newLine to the hashmap, then saves to the file
    // 
    {
        HashingFunction.addToHash(hashTable, newLine);
        this.saveAllData();
    }
    public String getStringByIdent(String ident)
    {
        return HashingFunction.returnHash(hashTable, ident.hashCode());
    }
    public void loadAllData() // gets the contents of the storage file;
    {
        try
        {
            ArrayList<String> toHashTable = new ArrayList<>(Files.readAllLines(storageFilePath));
            for(String item: toHashTable)
            {
                if(item.length() >= 4)
                // if the string is longer than 4 characters than it will be one of our strings
                {
                    HashingFunction.addToHash(hashTable, this.decryptString(item));
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: IO Exception has occured. Please contact your administrator."); // TODO: come up with better message
            e.printStackTrace(System.out);
        }
    }
    public void loadTableToInfo()
    // this will pass each string in the hashtable to StringParser to create corresponding entries in info
    {
        ArrayList<String> toLoad = new ArrayList<>(hashTable.values());
        for(String item: toLoad)
        {
            String itemIdent = IdentGet.getIdent(item);
            this.logEvent(new StorageEvent(storChange.LOADING_TO_INFO, itemIdent));
        }
    }
    public void eraseEntry(String toDelete)
            // This will be used for the delete use case
    {
        HashingFunction.removeEntry(hashTable, toDelete);
        this.saveAllData();
    }
    public void overWriteEntry(String newline)
    // this bypasses the collision detection of the hash function, ensuring that the entry is overwritten
    {
        String ident = IdentGet.getIdent(newline); // this is the ident to overwrite
        HashingFunction.removeEntry(hashTable, this.getStringByIdent(ident));
        this.setData(newline);
    }
    public void saveAllData()
    {
        try
        {
            ArrayList<String> toEncrypt = HashingFunction.toArray(hashTable);
            ArrayList<String> toStore = new ArrayList<>();
            for(String item: toEncrypt)
            {
                toStore.add(this.encryptString(item));
                //now encrypts during file save
            }
            Files.write(storageFilePath, toStore);
        }
        catch(IOException e)
        {
            System.out.println("Error: IO Exception has occured. Please contact your administrator."); // TODO: come up with better message
            e.printStackTrace(System.out);
        }
    }
    private String encryptString(String line)
    // encrypts the string. Note it is private to guard against attackers -Maxwell
    {
        byte[] toEncrypt = null;
        try
        {
            toEncrypt = line.getBytes("UTF-8");
        }
        catch(Exception e)
        {
            
        }
        try
        {
            cipher.init(ENCRYPT_MODE, key, new IvParameterSpec(new byte[16]));
            toEncrypt = cipher.doFinal(toEncrypt);
            
        }
        catch(InvalidKeyException e)
        {
            System.out.println("Error: Invalid key for encryption");
            e.printStackTrace(System.out);
        }
        catch(IllegalBlockSizeException e)
        {
            System.out.println("Error: Invalid Block Size");
            e.printStackTrace(System.out);
        }
        catch(BadPaddingException e)
        {
            System.out.println("Error: Your Padding Sucks"); //TODO: actually know what bad padding is
            e.printStackTrace(System.out);
        }
        catch(InvalidAlgorithmParameterException e)
        {
            System.out.println("I don't even know right now, come up with something later");
            e.printStackTrace(System.out);
        }
        
        String encrypted = null;
        try
        {
            encrypted = Base64.getEncoder().encodeToString(toEncrypt);
        }
        catch(Exception e)
        {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            e.printStackTrace(System.out);
        }
        return encrypted;
    }
    private String decryptString(String line)
    {
        //line = line.replaceAll("", "\n");
        byte[] toDecrypt = null;
        try
        {
            toDecrypt = line.getBytes("UTF-8");
        }
        catch(Exception e)
        {
            
        }
        try
        {
            cipher.init(DECRYPT_MODE, key, new IvParameterSpec(new byte[16]));
            toDecrypt = cipher.doFinal(Base64.getDecoder().decode(toDecrypt));
        }
        catch(InvalidKeyException e)
        {
            System.out.println("Error: Invalid key for encryption");
            e.printStackTrace(System.out);
        }
        catch(IllegalBlockSizeException e)
        {
            System.out.println("Error: Invalid Block Size");
            e.printStackTrace(System.out);
        }
        catch(BadPaddingException e)
        {
            System.out.println("Error: Your Padding Sucks"); //TODO: actually know what bad padding is
            e.printStackTrace(System.out);
        }
        catch(InvalidAlgorithmParameterException e)
        {
            System.out.println("I don't even know right now, come up with something later");
            e.printStackTrace(System.out);
        }
        String decrypted = null;
        try {
            decrypted = new String(toDecrypt, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decrypted;
    }
    public StorageEvent getEvent()
    {
        return this.lastEvent;
    }
    public void addObserver(Observer O)
    {
        this.observers.add(O);
    }
    public void logEvent(StorageEvent event)
    {
        this.lastEvent = event;
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
// And the rain drops [x47]