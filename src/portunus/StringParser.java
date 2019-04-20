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
    /*Bottom two functions return entire array for Info class*/
    public ArrayList<String> getAllSecQuestions()
    {
        return secQuestions;
    }
    
    public ArrayList<String> getAllSecAnswers()
    {
        return secAnswers;
    }
    public StringPEvent getEvent()
    {
        return this.lastEvent;
    }
    public void addObserver(Observer O)
    {
        this.observers.add(O);
    }
    public void logEvent(StringPEvent event)
    {
        this.lastEvent = event;
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
