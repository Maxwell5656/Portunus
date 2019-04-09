/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Maxwell
 */
public class Portunus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO code application logic here
        Storage storTest = new Storage("StorageFileTest.txt", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        //storTest.TestWrite("Get the flan in the face");
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
        storTest.setData("Who's in a bunker?" +
"Who's in a bunker?" +
"Women and children first" +
"And the children first" +
"And the children" +
"I'll laugh until my head comes off" +
"I'll swallow till I burst" +
"Until I burst" +
"Until I" +
"Who's in a bunker?" +
"Who's in a bunker?" +
"I have seen too much" +
"I haven't seen enough" +
"You haven't seen it" +
"I'll laugh until my head comes off" +
"Women and children first" +
"And children first" +
"And children" +
"Here I'm alive" +
"Everything all of the time" +
"Here I'm alive" +
"Everything all of the time" +
"Ice age coming" +
"Ice age coming" +
"Let me hear both sides" +
"Let me hear both sides" +
"Let me hear both" +
"Ice age coming" +
"Ice age coming" +
"Throw it in the fire" +
"Throw it in the fire" +
"Throw it on the" +
"We're not scaremongering" +
"This is really happening" +
"Happening" +
"We're not scaremongering" +
"This is really happening" +
"Happening" +
"Mobiles squerking" +
"Mobiles chirping" +
"Take the money run" +
"Take the money run" +
"Take the money" +
"Here I'm alive" +
"Everything all of the time" +
"Here I'm alive" +
"Everything all of the time" +
"Here I'm alive" +
"Everything all of the time" +
"Here I'm alive" +
"Everything all of the time" +
"The first of the children [Repeat until fade]", 9); // to test how may seq questions we can stuff into this damn thing
        
        /*byte[] bytes = new byte[16];
        String plzwork = "AAAAAAAA";
        storTest.setData(plzwork, 0);
        System.out.println(storTest.getStringByIdx(0));*/
        for(int i = 0; i<10; i++)
        {
           System.out.println(storTest.getStringByIdx(i));
           storTest.eraseEntry(i);
        }
        
    }
}
