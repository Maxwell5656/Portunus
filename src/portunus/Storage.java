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
import javax.crypto.Cipher;
/**
 *
 * @author Maxwell
 */
public class Storage {
    //TODO: Make Storage Class
    private BufferedReader fileIn;
    private BufferedWriter fileOut;
    
    
    public Storage(String fileName)
    // Note this is designed for files stored in User.dir. This location can be found in Help->About in Netbeans -Maxwell
    {
        String fileLocation = System.getProperty("user.dir") + fileName;
        
        //fileIn = new BufferedReader(new FileReader());
    }
}
