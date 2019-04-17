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
    private InfoEvent lastEvent; //logs events. everytime this happens, should notify observers;
    private ArrayList<Observer> observers; // will notify all of updates.
    
    public Info()
    {
        infoUnits = new ArrayList<>();
        identMaker = new Random();
        identValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // consists of caps values of all 27 roman letters
        observers = new ArrayList<>();
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
    
    public void createInfoUnit()
            // note how all three return strings. This is so that the view can bookkeep easier 
            // by storing the ident in its objects -Maxwell
    {
        String newIdent = this.forgeIdent();
        InfoUnit newUnit = new InfoUnit(newIdent);
        infoUnits.add(newUnit);
        this.logEvent(InfoChange.ITEM_CREATED, newIdent);
    }
    
    public void createInfoUnit(String username, String password)
    {
        String newIdent = this.forgeIdent();
        InfoUnit newUnit = new InfoUnit(newIdent, username, password);
        infoUnits.add(newUnit);
        this.logEvent(InfoChange.ITEM_CREATED, newIdent);
    }
    
    public void createInfoUnit(String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        String newIdent = this.forgeIdent();
        InfoUnit newUnit = new InfoUnit(newIdent, username, password, secQuestions, secAnswers);
        infoUnits.add(newUnit);
        this.logEvent(InfoChange.ITEM_CREATED, newIdent);
    }
    public boolean deleteInfoUnit(String ident)
            // returns true if object was successfully removed
    {
       InfoUnit item = this.findIdent(ident);
       if(item != null)
           // if the item to delete exists
       {
           this.infoUnits.remove(item);
           this.logDeleteEvent(item);
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
           this.logEvent(InfoChange.ITEM_CHANGED, ident);
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
            this.logEvent(InfoChange.ITEM_CHANGED, ident);
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
            this.logEvent(InfoChange.ITEM_CHANGED, ident);
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
            this.logEvent(InfoChange.ITEM_CHANGED, ident);
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
    public void addObserver(Observer toAdd)
    {
        observers.add(toAdd);
    }
    private void logEvent(InfoChange event, String ident)
    //Sets an event according to change
    {
        this.lastEvent = new InfoEvent(event, ident);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
    
    private void logDeleteEvent(InfoUnit toDelete)
    //Sets an event according to change
    //This alternate version will log an event spelling a deleted object
    {
        this.lastEvent = new InfoEvent(toDelete);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
    public InfoEvent getEvent()
    {
        return this.lastEvent;
    }
}
