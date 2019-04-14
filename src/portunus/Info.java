/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maxwell
 */
public class Info {
    private ArrayList<InfoUnit> infoUnits;
    private Random identMaker;
    private final String identValues; // this will contain all possible characters for the ident of each array unit
    
    public Info()
    {
        infoUnits = new ArrayList<>();
        identMaker = new Random();
        identValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // consists of caps values of all 27 roman letters
    }
    
    public InfoUnit findIdent(String Ident)
    // finds a specific InfoUnit based on the ident
    {
        for(InfoUnit infoUnit: infoUnits)
        {
            if(infoUnit.getIdent() == Ident)
            {
                return infoUnit;
            }
        }
        return null; // if no given object can be found then return null
    }
    private String forgeIdent()
    {
        String newIdent = "";
        for(int i = 0; i < 4; i++)
        {
            newIdent += identValues.charAt(identMaker.nextInt(26));
        }
        return newIdent;
    }
    
    public String createInfoUnit()
            // note how all three return strings. This is so that the view can bookkeep easier 
            // by storing the ident in its objects -Maxwell
    {
        InfoUnit newUnit = new InfoUnit(this.forgeIdent());
        infoUnits.add(newUnit);
        return newUnit.getIdent();
    }
    
    public String createInfoUnit(String username, String password)
    {
        InfoUnit newUnit = new InfoUnit(this.forgeIdent(), username, password);
        infoUnits.add(newUnit);
        return newUnit.getIdent();
    }
    
    public String createInfoUnit(String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        InfoUnit newUnit = new InfoUnit(this.forgeIdent(), username, password, secQuestions, secAnswers);
        infoUnits.add(newUnit);
        return newUnit.getIdent();
    }
    public boolean deleteInfoUnit(String ident)
            // returns true if object was successfully removed
    {
       InfoUnit item = this.findIdent(ident);
       if(item != null)
       {
           this.infoUnits.remove(item);
           return true;
       }
       return false;
    }
    
    // note that all these get/set functions have means of checking if the action was performed.
    // sets use boolean values whereas gets use null pointers to tell if something has gone wrong.
    // Be sure to incorporate this into resulting code -Maxwell 
    public boolean setPassword(String password, String ident)
    {
       InfoUnit item = this.findIdent(ident);
       if(item != null) 
       {
           item.setPassword(password);
           return true;
       }
       return false;
    }
    public String getPassword(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null) return item.getPassword();
        return null;
    }
    public boolean setUsername(String username, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) 
        {
            item.setUsername(username);
            return true;
        }
        return false;
    }
    public String getUsername(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null) return item.getUsername();
        return null;
    }
    public boolean addSecQuestion(String secQuestion, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null)
        {
            item.addSecQuestion(secQuestion);
            return true;
        }
        return false;
    }
    public String getSecQuestion(int idx, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) return item.getSecQuestion(idx);
        return null;
        // this function is depreciated -Maxwell
    }
    public boolean addSecAnswer(String secAnswer, String ident)
    {
        InfoUnit item  = this.findIdent(ident);
        if(item != null)
        {
            item.addSecAnswer(secAnswer);
            return true;
        }
        return false;
    }
    public String getSecAnswer(int idx, String ident)
    {
        //InfoUnit item = this.findIdent(ident);
        //return this.findIdent(ident).getSecAnswer(idx);
        // abandoned for now -Maxwell
        return null;
    }
    // something tells me that these get/set for secQuestion/Answer (those that use idx) won't be needed
    // in the final program, as display/storage will involve all of them.
    public ArrayList<String> getAllSecAnswers(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) return item.getAllSecAnswers();
        return null;
    }
    public ArrayList<String> getAllSecQuestions(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) return item.getAllSecQuestions();
        return null;
    }
}
