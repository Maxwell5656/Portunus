/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author paddy
 */
public class HashingFunction 
{
    //Function for hashing is java string class's hashcode algorithm
    //cuts down on complexity of code
    /** 
     * Creates a ConcurrentHashMap object with default size of 128 and returns
     * it.
     * 
     * @return ConcurrentHashTable accountTable
     */
    public static ConcurrentHashMap createTable()
    {
        //creates a hash table for user's info
        //using a concurrent hash map because it auto-handles collisions and has some functions built-in that simplify
        //hashing process
        ConcurrentHashMap<Integer, String> accountTable = new ConcurrentHashMap<>(128);
        return accountTable;
    }
    
     /**
     *
     * Takes a String input and ConcurrentHashMap input, uses that string to generate a hash code,
     * then adds that string and corresponding hash code into the specified 
     * ConcurrentHashMap
     * 
     * @param name ConcurrentHashMap to be modified
     * @param info String to add to map
     * 
     */
    public static void addToHash(ConcurrentHashMap name, String info)
    {
        //adds information to the hash table connected to the current user
        //takes account information string as an argument and adds it to the user's hash set
        name.put(getHashKey(info), info);
    }
    
     /**
     * 
     * Takes a String input and ConcurrentHashMap input, uses that string to 
     * generate a hash code, then searches for that specified hash code/string 
     * pair, and removes it from the ConcurrentHashMap
     * 
     * @param name ConcurrentHashMap to be modified
     * @param info String to be removed from map
     */
    public static void removeEntry(ConcurrentHashMap name, String info)
    {
        //removes entry from hash table
        name.remove(getHashKey(info),info);
    }
    
    /**
     * 
     * Takes a ConcurrentHashMap and an integer input, uses the integer to find
     * a location in the ConcurentHashMap that corresponds to the key, and
     * returns an object that contains the value at that location. Specifically
     * uses an integer to make a more customizable function
     * 
     * @param name ConcurrentHashMap to be searched
     * @param key Integer value of the location to be found
     * @return Object return of the value associated with the specific key
     */
    public static String returnHash(ConcurrentHashMap<Integer, String> name, int key)
    {
        //iterates over the has table and returns the entries of the table 
        return name.get(key);
    }
    //function that takes a concurrent hash map and spits out a collection/arraylist
    /**
     * 
     * Takes a ConcurrentHashMap and generates an array of strings from it.
     * 
     * @param name ConcurentHashMap that is the basis of the array that will be made
     * @return String[] that contains all the entries of the base ConcurrentHashMap
     */
    public static ArrayList<String> toArray(ConcurrentHashMap<Integer, String> name)
    {
        //Converts a concurrent hash map object into a set object and then into an array of strings
       ArrayList<String> infoArray =  new ArrayList<>(name.values());
        return infoArray;
    }
    
    /**
     * 
     * Returns an integer value to use as the hash key
     * 
     * @param info String identifier that is converted into the integer key
     * @return int value that is the key for hashing
     */
    public static int getHashKey(String info)
    // This function shall get a string of the Ident only, using that as a hash key.
    // This ensures that the hash function keeps the strings hashing to the same location, even if the items keep changing.
    {
        //String ident = Ident.getIdent
        return IdentGet.getIdent(info).hashCode();
    }
}
