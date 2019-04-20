/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

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
        Info info = new Info();
        Storage store = new Storage("StorageFileTest.txt", "ASSHOLE");
        StringParser parse = new StringParser();
        
        store.addObserver(new StorageToStringParse(store, parse));
        parse.addObserver(new StringParseToInfo(info, parse));
        
        store.loadTableToInfo();
        /*info.addObserver(new InfoToStringConcat(concat, info));
        concat.addObserver(new StringConcatToStorage(store, concat));
        
        info.createInfoUnit("ASS", "FurAffinity.com", "666666666", new ArrayList<>(), new ArrayList<>());*/
    }
}
