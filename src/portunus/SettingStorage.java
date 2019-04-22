/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 *
 * @author Maxwell
 */
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
        
public class SettingStorage {
    private final int USERNAME_IDX = 0; // these are just bookkeeping variables to show what index stores what in the
    private final int PASSWORD_IDX = 1;// array list. 
    private final int COLOR_IDX = 2;
    private final int TEXT_SIZE_IDX = 3;
    
    private final int KEYINT = 0x4EED; // this will be the keey for encrypting username and password;
    private SecretKeySpec key;
    private ArrayList<String> settings;
    private final Path filePath;
    private boolean userExists; // this will be false if no username or password is found upon creation, or if user selects "create new account"
    private ArrayList<Observer> observers;
    private Cipher cipher;
    /**
     * 
     * Creates a new SettingStorage path in user directory
     * 
     * @param newFile String name of the new file to be created
     */
    public SettingStorage(String newFile)
        //create new SettingStorage path to
    {
        //generate key
        byte[] keyGen = null;
        MessageDigest sha = null;
        settings = new ArrayList<>();
        try
        {
            keyGen = ByteBuffer.allocate(4).putInt(KEYINT).array();
            sha = MessageDigest.getInstance("SHA-1");
            keyGen = sha.digest(keyGen);
            keyGen = Arrays.copyOf(keyGen, 16);
            key = new SecretKeySpec(keyGen, "AES"); 
        }
        catch(Exception e)
        {
            System.out.println("KEY SCREW UP");
        }
        try
        {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }
        catch(Exception e)
        {
            System.out.println("Error: Portunus could not find the required encryption algorithm. See Storage.java.");
            e.printStackTrace(System.out);
        }
        String fileLocation = System.getProperty("user.dir") + "\\" + newFile;
        this.filePath = Paths.get(fileLocation);
        
        if(!Files.exists(this.filePath))
        {
            this.createNewStorageFile();
        }
        this.loadSettings();
        //TODO: set the colors to the default Portunus if no existing colors are found
    }
    /**
     * 
     * Finds the location of the stored settings in memory and takes their 
     * values to use in initialization
     * 
     */
    public void loadSettings()
    {
        try
        {
            settings = new ArrayList<>(Files.readAllLines(filePath));
            if(settings.size() < 4) // indicates file is not large enough to hold data
            {
                for(int i = USERNAME_IDX; i<TEXT_SIZE_IDX+1; i++)
                {
                    settings.add("");
                }
            }
            if(("".equals(settings.get(USERNAME_IDX)))||("".equals(settings.get(PASSWORD_IDX))))
            {
                this.userExists = false;
                // TODO: Add event to send to thing or initializer to handle this.
            }
            else this.userExists = true;
            if("".equals(this.settings.get(COLOR_IDX)))
            {
                this.setColor(new Color(51, 204, 255, 255));
            }
            if("".equals(this.settings.get(TEXT_SIZE_IDX)))
            {
                this.setFontSize("NORMAL");
            }
        }
        catch(Exception E)
        {
            System.out.println("ERROR:" + E.toString());
            E.printStackTrace(System.out);
        }
        //TODO: set the colors to the default Portunus if no existing colors are found
    }
    private void createNewStorageFile()
    /**
     * 
     * CReates a new file in storage
     * 
     */
    {
        try
        {
            Files.createFile(this.filePath);
        }
        catch(Exception E)
        {
            System.out.println("ERROR:" + E.toString());
            E.printStackTrace(System.out);
        }
        this.saveData();
    }
    
    /**
     * 
     * Changes the user's Portunus username
     * 
     * @param username String input of the user's new username
     * @param key int encryption key of for the input string
     */
    public void setUsername(String username, int key)
    {
        if (key == this.KEYINT) 
        {
            this.settings.set(USERNAME_IDX, this.encryptString(username));
            this.saveData();
        }
        // checks to see if the user is authentic by requiring the encryption key to be entered
        // get/set for password also does this
    }
    
    /**
     * 
     * Returns the username that is in storage
     * 
     * @param key int encryption key to be compared to information
     * @return String username for the associated key
     */
    public String getUsername(int key)
    {
        if (key == this.KEYINT) return this.decryptString(this.settings.get(USERNAME_IDX));
        else return null;
    }
    
    /**
     * 
     * Changes the user's Portunus password
     * 
     * @param password String new password for the user
     * @param key int encryption key for user validation
     */
    public void setPassword(String password, int key)
    {
        if (key == this.KEYINT) 
        {
            this.settings.set(PASSWORD_IDX, this.encryptString(password));
            this.saveData();
        }
        // checks to see if the user is authentic by requiring the encryption key to be entered
    }
    
    /**
     * 
     * Returns the value of the password currently stored
     * 
     * @param key int value to check if user is valid
     * @return String containing the stored password
     */
    public String getPassword(int key)
    {
        if (key == this.KEYINT) return this.decryptString(this.settings.get(PASSWORD_IDX));
        else return null;
    }
    
    /**
     * 
     * Sets the GUI to the user's choice of color upon startup
     * 
     * @param userChoice Color that the user has chosen
     */
    public void setColor(Color userChoice)
    {
        int argbData = userChoice.getRGB();
        this.settings.set(COLOR_IDX, Integer.toString(argbData));
        this.saveData();
    }
    public Color getColor()
    {
        int argbData = Integer.parseInt(this.settings.get(COLOR_IDX));
        return new Color(argbData, true);
    }
    public void setFontSize(String fontSize)
    {
        this.settings.set(TEXT_SIZE_IDX, fontSize);
        this.saveData();
    }
    public String getFontSize()
    {
        return this.settings.get(TEXT_SIZE_IDX);
    }
    public boolean userExists()
    {
        return this.userExists;
    }
    private void saveData()
    {
        try
        {
            Files.write(filePath, settings);
        }
        catch(Exception E)
        {
            System.out.println("ERROR:" + E.toString());
            E.printStackTrace(System.out);
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
}
