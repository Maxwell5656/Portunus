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
public class Portunus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Storage storTest = new Storage("StorageFileTest.txt");
        storTest.TestWrite("Get the flan in the face\n");
        storTest.closeFiles();
    }
    
}
