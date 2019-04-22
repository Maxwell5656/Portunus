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
//TODO: Add WebsiteName to StringConcater
public class StringConcater {
    private String ident; // This is how the unencrypted user info objects will be identified
    //I believe this will be a random 4-character arrangement of letters, maybe letters and numbers if it's not too hard on the hash function;
    // -Maxwell
    private String siteName;
    private String password;
    private String username;
    private ArrayList<String> secQuestions;
    private ArrayList<String> secAnswers;
    
    private ArrayList<Observer> observers;
    private StringCEvent lastEvent;
    
    /**
     * 
     * Default constructor for StringConcater object
     * 
     */
    public StringConcater()
    {
        ident = "";
        siteName = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
        observers =  new ArrayList<>();
    }
    
    /**
     * 
     * Resets all storage fields in the StringConcater object
     * 
     */
    public void reset() // resets all inputs to empty values, so that no login info is left inside this object
    {
        ident = "";
        siteName = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
    /**
     * 
     * Takes all the information stored in the StringConcater object and creates
     * a string with special identifiers from it.
     * 
     * @return String that has been generated 
     */
    public String concat()
    {
        String concatedString; 
        concatedString = ident + "|||" + siteName + "***" + password + "**|" + username;
        // for now, three asteriks in sequence shall divide each morsel of info
        // unlikely to appear in any password but will still need check for this at user entry.
        // if anyone has a better idea please send it my way -Maxwell
        // TODO: Create unique 3 character identifiers for each part of the string to aid in parsing
        // the string -Maxwell
        for(String question: secQuestions)
        {
            concatedString += "*|*" + question ;
        }
        for(String answer: secAnswers)
        {
            concatedString += "*||" + answer ;
        }
        // Important to note that questions and answers are placed in separate sections of the thing
        // rather than a sequence of question followed by answer -Maxwell
        this.reset(); // don't want to have login info still in string after conncatenation.
        return concatedString;
    }
    
    /**
     * 
     * Returns the value stored in the ident field of the StringConcater object
     * 
     * @return String ident field of Storage object
     */
    public String getIdent()
    {
        return ident;
    }
    
    /**
     * 
     * Updates the value stored in the ident field to the input String.
     * 
     * @param ident String input used to update the stored value
     */
    public void setIdent(String ident)
    {
        this.ident = ident;
    }
    
    /**
     * 
     * Gets the siteName of associated Storage object
     * 
     * @return String siteName of associated Storage object
     */
    public String getSiteName()
    {
        return siteName;
    }
    
    /**
     * 
     * Sets the siteName of associated Storage object
     * 
     * @param siteName String input for what the siteName should be updated to
     */
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    
    /**
     * 
     * Returns the value stored in the password field of the StringConcater object
     * 
     * @return String containing the stored value
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * 
     * Updates the value stored in the password field
     * 
     * @param password String value used to update the password field
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * 
     * Returns the value stored in the username field
     * 
     * @return String containing the value stored in the username field
     */
    public String getUsername()
    {
        return username;
    }
    
     /**
     * 
     * Updates the value stored in the username field 
     * 
     * @param username String input used to update the username field
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * 
     * Returns the value stored at a specified index of secQuestions
     * 
     * @param indx int value corresponding to the index of a value
     * @return String containing the value stored at the specified index
     */
    public String getSecQuestion(int indx)
    {
        return secQuestions.get(indx);
    }
    
    /**
     * 
     * Adds a new value to the ArrayList in the field secQuestion
     * 
     * @param question String input to be added to the ArrayList
     */
    public void addSecQuestion(String question)
    {
        secQuestions.add(question);
    }
    
    /**
     * 
     * Returns the value at a specific index in the ArrayList in secAnswers
     * 
     * @param indx int input used to specify the index of desired String
     * @return String value at corresponding index
     */
    public String getSecAnswer(int indx)
    {
        return secAnswers.get(indx);
    }
    
    /**
     * 
     * Adds another entry to the ArrayList in secAnswer.
     *  
     * @param question String input to be added to the ArrayList
     */
    public void addSecAnswer(String question)
    {
        secAnswers.add(question);
    }
    
    /**
     * 
     * Adds an observer for the StringConcater object
     * 
     * @param Obs Observer that observes the object
     */
    public void addObserver(Observer Obs)
            // Sets an observer to observe StringConcater. Note that the observer cannot easily be removed
    {
        observers.add(Obs);
    }
    /**
     * 
     * REturns the last event 
     * 
     * @return StringCEvent last event 
     */
    public StringCEvent getEvent()
    {
        return lastEvent;
    }
    
    /**
     * 
     * Updates all values in the fields of StringConcater
     * 
     * @param ident String input used to update the ident field
     * @param username String input used to update the password field
     * @param password String input used to update the username field
     * @param secQuestions ArrayList of String type used to update the secQuestions field
     * @param secAnswers ArrayList of String type used to update the secAnswers field
     */
    public void setAll(String ident, String siteName, String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        this.setIdent(ident);
        this.setPassword(password);
        this.setSiteName(siteName);
        this.setUsername(username);
    //if(!secQuestions.isEmpty())
    //{
        for(String question: secQuestions)
        {
            this.addSecQuestion(question);
        }
    //}
    //if(!secAnswers.isEmpty())
    //{
        for(String answer: secAnswers)
        {
            this.addSecAnswer(answer);
        }
    //}
    }
    
    /**
     * 
     * Logs an event that happens
     * 
     * @param event StringCEvent that has been updated
     */
    public void logEvent(StringCEvent event)
        // this function is public as it needs an event to be gotten from infoEvent
    {
        this.lastEvent = event;
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
