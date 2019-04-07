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

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import javax.crypto.Cipher;
/**
 *
 * @author Maxwell
 */
public class Storage {
    //TODO: Make Storage Class
    //private BufferedReader fileIn;
    //private File storageFile;
    //private BufferedWriter fileOut;
    private final Path storageFilePath; //this tells how the class will get to the file.
    private static final int SIZE = 10; //This will be the size of the Hash Table.
    private ArrayList<String> hashTable;
    
    public Storage(String fileName)
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
    }
    public void TestWrite(String Line) // this is just a function to test the writing capabilities
    {
        //depreciated
    }
    public void setData(String newLine, int idx)
    // sets the value at the given idx to newLine, then saves to the file
    // 
    {
        hashTable.set(idx, newLine);
        this.saveAllData();
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
}
// And the rain drops