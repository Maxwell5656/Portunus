/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 * Contains one static method to get the first four characters of a StringConcater string.
 * @author Maxwell
 */
public class IdentGet {
    //This is just one static function to easily get the ident of a StringConcated String
    
    /**
     * 
     * Finds the ident value of a concatenated string
     * 
     * @param concated String input that is used to get the identifier value
     * @return String value that is the identifier value of the String that was input
     */
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
