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
    private ArrayList<String> hashTable;
    private Cipher cipher;
    private SecretKeySpec key;
    private byte[] keyGen; // this is a test value for now.
    
    public Storage(String fileName, String key)
    // Note this is designed for files stored in User.dir. This location can be found in Help->About in Netbeans -Maxwell
    {
        String fileLocation = System.getProperty("user.dir") + "\\" + fileName;
        storageFilePath = Paths.get(fileLocation); // tracks the location of this file
        this.loadAllData();
        System.out.println(hashTable.size());
        if(hashTable.size() < SIZE) //if the file is smaller than the size, then add elements as needed.
            // if the file is larger than size, this shouldn't be much of a problem, as nothing will likely hash to those larger values
            // -Maxwell
        {
            for(int i = hashTable.size(); i<SIZE; i++)
            {
                System.out.println(hashTable.size());
                hashTable.add(""); // initializes to a bunch of empty strings
                // note that the Files.write function automatically appends a newline character to each string in the file.
            }
            this.saveAllData();
        }
        // Note: this if statement appears to write too many additional lines.
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
            
        }
    }
    public void TestWrite(String Line) // this is just a function to test the writing capabilities
    {
        //depreciated
    }
    public void setData(String newLine, int idx)
    // sets the value at the given idx to newLine, then saves to the file
    // 
    {
        hashTable.set(idx, this.encryptString(newLine));
        this.saveAllData();
    }
    public String getStringByIdx(int idx)
    {
        return this.decryptString(hashTable.get(idx));
    }
    public void loadAllData() // gets the contents of the storage file;
    {
        try
        {
            hashTable = new ArrayList<>(Files.readAllLines(storageFilePath));
    
        }
        catch(IOException e)
        {
            System.out.println("Error: IO Exception has occured. Please contact your administrator."); // TODO: come up with better message
            e.printStackTrace(System.out);
        }
    }
    public void eraseEntry(int idx)
            // This will be used for the delete use case
    {
        hashTable.set(idx, "");
        this.saveAllData();
    }
    public void saveAllData()
    {
        try
        {
            Files.write(storageFilePath, hashTable);
        }
        catch(IOException e)
        {
            System.out.println("Error: IO Exception has occured. Please contact your administrator."); // TODO: come up with better message
            e.printStackTrace(System.out);
        }
    }
    public void closeFiles()
    {
        //depreciated
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
        //encrypted = encrypted.replaceAll("(?:\\r\\n|\\n\\r|\\n|\\r)", "");
        // I got this from stackOverflow("https://stackoverflow.com/questions/10282566/avoiding-line-breaks-in-encrypted-and-encoded-url-string/20587169")
        // Hopefully it works -Maxwell
        
        String encrypted = null;
        try
        {
            encrypted = Base64.getEncoder().encodeToString(toEncrypt);
        }
        catch(Exception e)
        {
            //TODO add something later
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
}
// And the rain drops