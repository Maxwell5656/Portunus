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
    
    public void reset() // resets all inputs to empty values, so that no login info is left inside this object
    {
        ident = "";
        siteName = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
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
    
    public String getIdent()
    {
        return ident;
    }
    
    public void setIdent(String ident)
    {
        this.ident = ident;
    }
    
    public String getSiteName()
    {
        return siteName;
    }
    
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getSecQuestion(int indx)
    {
        return secQuestions.get(indx);
    }
    public void addSecQuestion(String question)
    {
        secQuestions.add(question);
    }
    public String getSecAnswer(int indx)
    {
        return secAnswers.get(indx);
    }
    public void addSecAnswer(String question)
    {
        secAnswers.add(question);
    }
    public void addObserver(Observer Obs)
            // Sets an observer to observe StringConcater. Note that the observer cannot easily be removed
    {
        observers.add(Obs);
    }
    public StringCEvent getEvent()
    {
        return lastEvent;
    }
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
