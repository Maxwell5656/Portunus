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
public class IdentGet {
    //This is just one static function to easily get the ident of a StringConcated String
    public static String getIdent(String concated)
    // This function shall get a string of the Ident only, using that as a hash key.
    // This ensures that the hash function keeps the strings hashing to the same location, even if the items keep changing.
    {
        if(concated.length() >= 4) 
        {
            String ident = concated.substring(0, 4);
            return ident;
        }
        return null;
    }
}
