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
        //storTest.TestWrite("Get the flan in the face\n");
        //storTest.closeFiles();
        storTest.setData("15 Step", 0);
        storTest.setData("BodySnatchers", 1);
        storTest.setData("Nude", 2);
        storTest.setData("Weird Fishes/Arpeggi", 3);
        storTest.setData("All I Need", 4);
        storTest.setData("Faust Arp", 5);
        storTest.setData("Reckoner", 6);
        storTest.setData("House of Cards", 7);
        storTest.setData("Jigsaw Falling Into Place", 8);
        storTest.setData("Videotape", 9);
        
        for(int i = 0; i<10; i++)
        {
            System.out.println(storTest.getStringByIdx(i));
        }
    }
}
