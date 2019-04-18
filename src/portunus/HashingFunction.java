/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author paddy
 */
public class HashingFunction 
{
    //Function for hashing is java string class's hashcode algorithm
    //cuts down on complexity of 
    public static ConcurrentHashMap createTable()
    {
        //creates a hash table for user's info
        //using a concurrent hash map because it auto-handles collisions and has some functions built-in that simplify
        //hashing process
        ConcurrentHashMap<Integer, String> accountTable = new ConcurrentHashMap(128);
        return accountTable;
    }
    
    public static void addToHash(ConcurrentHashMap name, String info)
    {
        //adds information to the hash table connected to the current user
        //takes account information string as an argument and adds it to the user's hash set
        name.put(getHashKey(info), info);
    }
    
    public static void removeEntry(ConcurrentHashMap name, String info)
    {
        //removes entry from hash table
        name.remove(getHashKey(info),info);
    }
    
    public static Object returnHash(ConcurrentHashMap name, int key)
    {
        //iterates over the has table and returns the entries of the table 
        return name.get(key);
    }
    //function that takes a concurrent hash map and spits out a collection/arraylist
    public static String[] toArray(ConcurrentHashMap name)
    {
        //Converts a concurrent hash map object into a set object and then into an array of strings
       String[] infoArray =  (String[]) name.entrySet().toArray();
        return infoArray;
    }
    private static int getHashKey(String info)
    // This function shall get a string of the Ident only, using that as a hash key.
    // This ensures that the hash function keeps the strings hashing to the same location, even if the items keep changing.
    {
        String ident = info.substring(0, 4);
        return ident.hashCode();
    }
}
