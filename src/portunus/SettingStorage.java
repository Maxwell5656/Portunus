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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
        
public class SettingStorage {
    private final int USERNAME_IDX = 0; // these are just bookkeeping variables to show what index stores what in the
    private final int PASSWORD_IDX = 1;// array list. 
    private final int COLOR_IDX = 2;
    private final int TEXT_SIZE_IDX = 3;
    
    private final int KEY = 0x4EED; // this will be the keey for encrypting username and password;
    private ArrayList<String> settings;
    private final Path filePath;
    private boolean userExists; // this will be false if no username or password is found upon creation, or if user selects "create new account"
    
    /**
     * 
     * Creates a new SettingStorage path in user directory
     * 
     * @param newFile String name of the new file to be created
     */
    public SettingStorage(String newFile)
        //create new SettingStorage path to
    {
        String fileLocation = System.getProperty("user.dir") + "\\" + newFile;
        this.filePath = Paths.get(newFile);
        
        if(!Files.exists(this.filePath))
        {
            this.createNewStorageFile();
        }
        this.loadSettings();
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
            if((settings.get(USERNAME_IDX) == "")||(settings.get(PASSWORD_IDX) == ""))
            {
                this.userExists = false;
                // TODO: Add event to send to thing or initializer to handle this.
            }
            else this.userExists = true;
        }
        catch(Exception E)
        {
            System.out.println("ERROR:" + E.toString());
            E.printStackTrace(System.out);
        }
    }
    
    /**
     * 
     * CReates a new file in storage
     * 
     */
    public void createNewStorageFile()
    {
        try
        {
            Files.createFile(this.filePath);
            //ArrayList<String> initFile = new ArrayList<>();
            //for(int i = 0)
        }
        catch(Exception E)
        {
            System.out.println("ERROR:" + E.toString());
            E.printStackTrace(System.out);
        }
        
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
        if (key == this.KEY) this.settings.set(USERNAME_IDX, username);
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
        if (key == this.KEY) return this.settings.get(USERNAME_IDX);
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
        if (key == this.KEY) this.settings.set(USERNAME_IDX, password);
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
        if (key == this.KEY) return this.settings.get(PASSWORD_IDX);
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
    }
}
