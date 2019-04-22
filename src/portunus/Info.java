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
    
    /**
     * 
     * Default constructor for the Info object
     * 
     * @author Maxwell
     */
    public Info()
    {
        infoUnits = new ArrayList<>();
        identMaker = new Random();
        identValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // consists of caps values of all 27 roman letters
        observers = new ArrayList<>();
    }
    
    /**
     * 
     * Searches for a specific identifier string and returns the value held 
     * in the specific InfoUnit
     * 
     * @param Ident String Identifier of the object to be found
     * @return InfoUnit object
     */
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
    
    /**
     * 
     * Creates a new identifier value for an InfoUnit object and returns it
     * 
     * @return newIdent as the new identifier of the InfoUnit
     */
    private String forgeIdent()
    {
        String newIdent = "";
        for(int i = 0; i < 4; i++)
        {
            newIdent += identValues.charAt(identMaker.nextInt(26));
        }
        for(InfoUnit unit: infoUnits)
        {
            if(unit.getIdent().equals(newIdent))
            {
                newIdent = this.forgeIdent();
            }
        }
        return newIdent;
    }
    
    /**
     * 
     * Dynamically creates new InfoUnit object t be added into the list of 
     * InfoUnits.
     * 
     */
    public void createInfoUnit()
            // note how all three return strings. This is so that the view can bookkeep easier 
            // by storing the ident in its objects -Maxwell
    {
        String newIdent = this.forgeIdent();
        InfoUnit newUnit = new InfoUnit(newIdent);
        infoUnits.add(newUnit);
        this.logEvent(InfoChange.ITEM_CREATED, newIdent);
    }
    
    /**
     * 
     * Creates an InfoUnit object for the purpose of storing a
     * username and password and adds it to the list of InfoUnits 
     * 
     * @param username String input to be stored
     * @param password String input to be stored
     */
    public void createInfoUnit(String username, String password)
    {
        String newIdent = this.forgeIdent();
        InfoUnit newUnit = new InfoUnit(newIdent, username, password);
        infoUnits.add(newUnit);
        this.logEvent(InfoChange.ITEM_CREATED, newIdent);
    }
    
    /**
     * 
     * Creates an InfoUnit object that stores a username String, password String,
     * String ArrayList of security questions, and String ArrayList of answers 
     * to those questions.
     * 
     * @param username String input to be stored
     * @param password String input to be stored
     * @param secQuestions String ArrayList to be stored
     * @param secAnswers String ArrayList to be stored
     */
    public void createInfoUnit(String username, String siteName, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        String newIdent = this.forgeIdent();
        InfoUnit newUnit = new InfoUnit(newIdent, siteName, username, password, secQuestions, secAnswers);
        infoUnits.add(newUnit);
        this.logEvent(InfoChange.ITEM_CREATED, newIdent);
    }
    
    /**
     * 
     * Same as createInfoUnit but it uses an existing ident and doesn't notify 
     * Storage to concatenate and store. Only to be called by StringParser 
     * or similar storage related class
     * 
     * @param ident String input to be stored
     * @param username String input to be stored
     * @param siteName
     * @param password String input to be stored
     * @param secQuestions String ArrayList to be stored
     * @param secAnswers String ArrayList to be stored
     */
    public void loadFromStorage(String ident, String username, String siteName, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
            //Same as createInfoUnit but it uses an existing ident and doesn't notify Storage to concat and store
            //Only to be called by StringParser or similar storage related class -Maxwell
    {
        InfoUnit newUnit = new InfoUnit(ident, siteName, username, password, secQuestions, secAnswers);
        infoUnits.add(newUnit);
    }
    
    /**
     * 
     * Removes an InfoUnit from the list and deletes it
     * 
     * @param ident String identifier for the InfoUnit to be deleted
     * @return boolean whether the delete was successful or not
     */
    public boolean deleteInfoUnit(String ident)
            // returns true if object was successfully removed
    {
       InfoUnit item = this.findIdent(ident);
       if(item != null)
           // if the item to delete exists
       {
           this.logDeleteEvent(item);
           this.infoUnits.remove(item);
           return true;
       }
       return false;
    }
    
    // note that all these get/set functions have means of checking if the action was performed.
    // sets use boolean values whereas gets use null pointers to tell if something has gone wrong.
    // Be sure to incorporate this into resulting code -Maxwell
    /**
     * 
     * Finds the InfoUnit in Info and changes its siteName value
     * 
     * @param siteName String input used to update siteName
     * @param ident String value used to find InfoUnit object
     * @return boolean value of if set was successful
     */
    public boolean setSiteName(String siteName, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) 
        {
            item.setSiteName(siteName);
            this.logEvent(InfoChange.ITEM_CHANGED, ident);
            return true;
        }
        return false;
    }
    
    /**
     * 
     * Returns the siteName of the associated InfoUnit
     * 
     * @param ident String input used to find the correct instance of InfoUnit
     * @return 
     */
    public String getSiteName(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null) return item.getSiteName();
        return null;
    }
    
    /**
     * 
     * Finds a particular InfoUnit, and changes the password parameter to the 
     * input.
     * 
     * @param password String input taken to update object
     * @param ident String input used to find the correct InfoUnit object
     * @return boolean if the update was successful
     */
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
    
    /**
     * 
     * Looks for a particular instance if InfoUnit and returns the password 
     * value in that object.
     * 
     * @param ident String identifier for finding the correct instance of InfoUnit
     * @return String containing the value contained in the storage section "password"
     */
    public String getPassword(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null) return item.getPassword();
        return null;
    }
    
    /**
     * 
     * Finds a particular instance of InfoUnit and updates the value contained in 
     * the username field
     * 
     * @param username String that will be used to update the username field
     * @param ident String identifier used to find the correct InfoUnit
     * @return boolean if the set was successful
     */
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
    
    /**
     * 
     * Finds a particular infoUnit and returns the value contained in the username 
     * field
     * 
     * @param ident String used to find the correct InfoUnit
     * @return String containing value in the username field
     */
    public String getUsername(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null) return item.getUsername();
        return null;
    }
    
    /**
     * 
     * Finds a particular InfoUnit and updates the field for secQuestion
     * 
     * @param secQuestion String input to be added to the InfoUnit
     * @param ident String used to find the correct InfoUnit
     * @return boolean if the add was successful
     */
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
    
    /**
     * 
     * Finds a particular infoUnit and returns the associated secQuestion.
     * 
     * @param idx int related to the location of the secQuestion to be returned
     * @param ident String used to find the correct infoUnit
     * @return String containing the wanted secQuestion
     */
    public String getSecQuestion(int idx, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) return item.getSecQuestion(idx);
        return null;
        // this function is depreciated -Maxwell
    }
    
    /**
     * 
     * Finds a particular InfoUnit and adds a String, secAnswer, to it.
     * 
     * @param secAnswer String input to be added 
     * @param ident String identifier used to find he correct InfoUnit
     * @return boolean if the add succeeded
     */
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
    
    /**
     * 
     * unused function
     * 
     * @param idx
     * @param ident
     * @return null
     */
    public String getSecAnswer(int idx, String ident)
    {
        //InfoUnit item = this.findIdent(ident);
        //return this.findIdent(ident).getSecAnswer(idx);
        // abandoned for now -Maxwell
        return null;
    }
    // something tells me that these get/set for secQuestion/Answer (those that use idx) won't be needed
    // in the final program, as display/storage will involve all of them.
    
    /**
     * 
     * Finds a particular InfoUnit and returns all associated SecAnswers
     * 
     * @param ident String identifier used to search
     * @return String ArrayList containing all the values associated with SecAnswers
     */
    public ArrayList<String> getAllSecAnswers(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) return item.getAllSecAnswers();
        return null;
    }
    
     /**
     * 
     * Finds a particular InfoUnit and returns all associated values in SecQuestions
     * 
     * @param ident String identifier used for the search
     * @return String ArrayList containing all values associated with SecQuestions
     */
    public ArrayList<String> getAllSecQuestions(String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if (item != null) return item.getAllSecQuestions();
        return null;
    }
    public boolean setAllSecQuestions(ArrayList<String> secQ, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null)
        {
            item.setAllSecQuestions(secQ);
            return true;
        }
        return false;
    }
    public boolean setAllSecAnswers(ArrayList<String> secA, String ident)
    {
        InfoUnit item = this.findIdent(ident);
        if(item != null)
        {
            item.setAllSecAnswers(secA);
            return true;
        }
        return false;
    }
    /**
     * 
     * Adds an observer to the list of observers.
     * 
     * @param toAdd Observer to be added.
     */
    public void addObserver(Observer toAdd)
    {
        observers.add(toAdd);
    }
    
    /**
     * 
     * Sets an event according to changes occurring.
     * 
     * @param event 
     * @param ident String identifier of an InfoUnit
     */
    private void logEvent(InfoChange event, String ident)
    //Sets an event according to change
    {
        this.lastEvent = new InfoEvent(event, ident);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
    
    /**
     * 
     * Logs an event of an InfoUnit being deleted
     * 
     * @param toDelete InfoUnit that is being deleted
     */
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
    
    /**
     * 
     * Returns the last Info event
     * 
     * @return InfoEvent that is the last event 
     */
    public InfoEvent getEvent()
    {
        return this.lastEvent;
    }
}
