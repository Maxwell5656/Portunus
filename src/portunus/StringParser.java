/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.util.ArrayList;

/**
 *
 * @author Maxwell
 */
public class StringParser 
/*
Takes strings from the storage class, separates into login info that the Info class can then keep track
of.        
Collaboratiors:
    +Info Class
    +Storage Class
   -Maxwell     
*/
{ // TODO: Consider making StringConcater and StringParser subclasses of one class
    private String ident;
    private String siteName;
    private String password;
    private String username;
    private ArrayList<String> secQuestions;
    private ArrayList<String> secAnswers;
    private StringPEvent lastEvent;
    private ArrayList<Observer> observers;
    
    /**
     * 
     * Default constructor for object of type StingParser
     * 
     */
    public StringParser() // initialize everything to empty values
    {
        ident = "";
        siteName = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
        observers = new ArrayList<>();
    }
    
    /**
     * 
     * Takes a string with special identifiers and separates it into the info 
     * contained within those strings based on the identifiers.
     * 
     * @param info String to be parsed
     */
    public void parseString(String info)
    {
        String newIdent = "";
        String newSiteName = "";
        String newPassword = "";
        String newUsername = "";
        String secQorA = "";
        // these will be copied into StringParser's values once these have been filled
        
        int idx = 0;
        while((idx < info.length())&&((info.charAt(idx) != '*')&&(info.charAt(idx) != '|'))) // get ident first, that is guaranteed to be in front.
        {   
            newIdent = newIdent + info.charAt(idx);
            idx++;
        }
        while(idx < info.length())
        {
            String key = info.substring(idx, idx+3); // get substring of the next codifier of parsing
            idx += 3; // increment by length of key
            switch(key)
            {
                case "|||":
                    while((idx < info.length())&&(info.charAt(idx) != '*'))
                        {   
                            newSiteName = newSiteName + info.charAt(idx);
                            idx++;
                        }
                break;
                case "***":
                    while((idx < info.length())&&(info.charAt(idx) != '*'))
                        {   
                            newPassword = newPassword + info.charAt(idx);
                            idx++;
                        }
                    //this.getFieldFrom(info, newPassword, idx);
                break;
                case "**|":
                    while((idx < info.length())&&(info.charAt(idx) != '*'))
                        {   
                            newUsername = newUsername + info.charAt(idx);
                            idx++;
                        }
                    //this.getFieldFrom(info, newUsername, idx);
                break;
                case "*|*":
                    //this.getFieldFrom(info, secQorA, idx);
                    secQorA = "";
                    while((idx < info.length())&&(info.charAt(idx) != '*'))
                        {   
                            secQorA = secQorA + info.charAt(idx);
                            idx++;
                        }
                    this.addSecQuestion(secQorA);
                break;
                case "*||":
                    //this.getFieldFrom(info, secQorA, idx);
                    secQorA = "";
                    while((idx < info.length())&&(info.charAt(idx) != '*'))
                        {   
                            secQorA = secQorA + info.charAt(idx);
                            idx++;
                        }
                    this.addSecAnswer(secQorA);
                break;
                default:
                break;
            }    
        }
        this.setIdent(newIdent);
        this.setSiteName(newSiteName);
        this.setPassword(newPassword);
        this.setUsername(newUsername);
        this.logEvent(new StringPEvent(storChange.LOADING_TO_INFO));
    }
    
    /**
     * 
     * Copies information from one String to another
     * 
     * @param getFrom String to pull information from
     * @param insertTo String to put information into
     * @param idx int input marking the starting point of copy
     */
    private void getFieldFrom(String getFrom, String insertTo, int idx)
            //TODO: Get this function working.
            //This function won't work unless we use pass by reference in the int, and we need to figure that out more
            //-Maxwell
    {
        String copyString = "";
        while((idx < getFrom.length())&&(getFrom.charAt(idx) != '*'))
        {   
            copyString = copyString + getFrom.charAt(idx);
            idx++;
        }
    }
    
    /**
     * 
     * Returns the value stored in the ident field of StringParser
     * 
     * @return String value in ident
     */
    public String getIdent()
    {
        return ident;
    }
    
    /**
     * 
     * Updates the String stored in ident
     * 
     * @param ident String input used to update the value
     */
    public void setIdent(String ident)
    {
        this.ident = ident;
    }
    
    /**
     * 
     * Gets the siteName in the StringParser object
     * 
     * @return String value from siteName
     */
    public String getSiteName()
    {
        return siteName;
    }
    
    /**
     * 
     * Sets the SiteName in the StringParser object
     * 
     * @param siteName String to be updated from 
     */
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    
    /**
     * 
     * Returns the value stored in the password field
     * 
     * @return String value from the password field
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * 
     * Updates the value associated with the password field
     * 
     * @param password String used to update the password field
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * 
     * Returns the value in the username field
     * 
     * @return String value associated with username
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * 
     * Updates the value associated with the username field
     * 
     * @param username String used to update username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * 
     * Gets the value stored in secQuestion at index indx
     * 
     * @param indx int index value in ArrayList
     * @return String associated with the index value
     */
    public String getSecQuestion(int indx)
    {
        return secQuestions.get(indx);
    }
    
    /**
     * 
     * Adds a new String to secQuestion
     * 
     * @param question String to be added
     */
    public void addSecQuestion(String question)
    {
        secQuestions.add(question);
    }
    
    /**
     * 
     * Gets the value of secAnswer at index indx
     * 
     * @param indx int index of ArrayList
     * @return String from associated index
     */
    public String getSecAnswer(int indx)
    {
        return secAnswers.get(indx);
    }
    
    /**
     * 
     * Adds a new String to the ArrayList in secAnswer
     * 
     * @param question String input to add
     */
    public void addSecAnswer(String question)
    {
        secAnswers.add(question);
    }
    /*Bottom two functions return entire array for Info class*/
    /**
     * 
     * Returns all Strings in the ArrayList associated with secQuestions
     * 
     * @return 
     */
    public ArrayList<String> getAllSecQuestions()
    {
        return secQuestions;
    }
    
    /**
     * 
     * REturns all Strings in the ArrayList associated with secAnswers
     * 
     * @return ArrayList with all entries
     */
    public ArrayList<String> getAllSecAnswers()
    {
        return secAnswers;
    }
    
    /**
     * 
     * Event observer
     * 
     * @return StringPEvent of the last event
     */
    public StringPEvent getEvent()
    {
        return this.lastEvent;
    }
    
    /**
     * 
     * Adds an observer to the StringParser object
     * 
     * @param O Observer to be added
     */
    public void addObserver(Observer O)
    {
        this.observers.add(O);
    }
    
    /**
     * 
     * Logs the events 
     * 
     * @param event StringPEvent that is being updated
     */
    public void logEvent(StringPEvent event)
    {
        this.lastEvent = event;
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
