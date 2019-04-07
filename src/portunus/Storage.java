/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
    private BufferedReader fileIn;
    private File storageFile;
    private BufferedWriter fileOut;
    private static final int SIZE = 10; //This will be the size of the Hash Table.
    private ArrayList<String> hashTable;
    
    public Storage(String fileName)
    // Note this is designed for files stored in User.dir. This location can be found in Help->About in Netbeans -Maxwell
    {
        hashTable = new ArrayList<>();
        for (int i = 0; i<SIZE; i++)
        {
            hashTable.add("\n"); //Will add sequence of newline characters, so that blank entries will be
            //only new line characteres. These will not be encrypted -Maxwell;
        }
        String fileLocation = System.getProperty("user.dir") + "\\" + fileName;
        try 
        {
            storageFile = new File(fileLocation);
            fileIn = new BufferedReader(new FileReader(storageFile));
        }
        catch(FileNotFoundException E)
        {
            System.out.println("ERROR: Storage File could not be found. Please check to see if it is in the right location (user.dir)");
            E.printStackTrace(System.out);
        }
        try
        {
            fileOut = new BufferedWriter(new FileWriter(storageFile));
        }
        catch(IOException E)
        {
            System.out.println("ERROR: IOException"); // TODO: add better message here
            E.printStackTrace(System.out);
        }
    }
    public void TestWrite(String Line) // this is just a function to test the writing capabilities
    {
        try
        {
        fileOut.write(Line);
        fileOut.flush();
        }
        catch(IOException E)
        {
            System.out.println("ERROR: IOException"); // TODO: add better message here
            E.printStackTrace(System.out);
        }
    }
    public void closeFiles()
    {
        try
        {
        fileIn.close();
        fileOut.close();
        }
        catch(IOException E)
        {
            System.out.println("ERROR: IOException"); // TODO: add better message here
            E.printStackTrace(System.out);
        }
    }
}
// And the rain drops