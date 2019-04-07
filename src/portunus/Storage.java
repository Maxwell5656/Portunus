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
    private Path storageFilePath;
    private static final int SIZE = 10; //This will be the size of the Hash Table.
    private ArrayList<String> hashTable;
    
    public Storage(String fileName)
    // Note this is designed for files stored in User.dir. This location can be found in Help->About in Netbeans -Maxwell
    {
        storageFilePath = Paths.get(System.getProperty("user.dir") + "SystemFileTest");
        
    }
    public void TestWrite(String Line) // this is just a function to test the writing capabilities
    {
        
    }
    public void closeFiles()
    {
        
    }
}
// And the rain drops