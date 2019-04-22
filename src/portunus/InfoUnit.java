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
public class InfoUnit {
    public String ident;
    public String siteName;
    public String username;
    public String password;
    public ArrayList<String> secQuestions;
    public ArrayList<String> secAnswers;
    
     /**
     * 
     * Default constructor for the InfoUnit object
     * 
     * @param ident String identifier for the created object
     */
    public InfoUnit(String ident)
    {
        this.ident = ident;
        username = "";
        password = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
    /**
     * 
     * Initialized constructor for InfoUnit object
     * 
     * @param ident String identifier for the object
     * @param username String value to be put into the "username" location
     * @param password String value to be put into the "password" location
     */
    public InfoUnit(String ident, String username, String password)
    {
        this.ident = ident;
        this.username = username;
        this.password = password;
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
    /**
     * 
     * Another initialized constructor
     * 
     * @param ident String identifier for the object
     * @param username String value to be put into the "username" location
     * @param password String value to be put into the "password" location
     * @param secQuestions String ArrayList to be stored by secQuentions
     * @param secAnswers String ArrayList to be stored by secAnswers
     */
    public InfoUnit(String ident, String siteName, String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        this.ident = ident;
        this.siteName = siteName;
        this.username = username;
        this.password = password;
        this.secQuestions = secQuestions;
        this.secAnswers = secAnswers;
    }
    
    /**
     * 
     * Changes the identifier string for specified InfoUnit object
     * 
     * @param ident String identifier to find the correct InfoUnit object
     */
    public void setIdent(String ident)
    {
        this.ident = ident;
    }
    
    /**
     * 
     * Returns the identifier String of the InfoUnit object
     * 
     * @return String identifier of the InfoUnit object
     */
    public String getIdent()
    {
        return ident;
    }
    
    /**
     * 
     * Sets the siteName of the InfoUnit 
     * 
     * @param siteName String input used to update the siteName
     */
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    
    /**
     * 
     * Returns the siteName of an InfoUnit object
     * 
     * @return String value of siteName
     */
    public String getSiteName()
    {
        return siteName;
    }
    
    /**
     * 
     * Changes the password of an InfoUnit object
     * 
     * @param password String to be passed to the password field
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * 
     * Returns the value stored in the password field of InfoUnit
     * 
     * @return String value stored in password field
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * 
     * Sets the value stored in the password field to the specified parameter
     * 
     * @param username String input to update the username field to
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * 
     * Returns the value stored in the username field of the InfoUnit object
     * 
     * @return String value stored in the username field
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * 
     * Updates the secQuestion field with the given input
     * 
     * @param secQuestion String input to add to the ArrayList under the field secQuestion
     */
    public void addSecQuestion(String secQuestion)
    {
        this.secQuestions.add(secQuestion);
    }
    
    /**
     * 
     * Returns a String associated with secQuestion
     * 
     * @param idx int value that corresponds to a String in the ArrayList of Strings
     * @return String value stored in the ArrayList
     */
    public String getSecQuestion(int idx)
    {
        return this.secQuestions.get(idx);
    }
    
    /**
     * 
     * Updates the secAnswers field with the given input
     * 
     * @param secAnswer String input to add to the ArrayList under the field secAnswers
     */
    public void addSecAnswer(String secAnswer)
    {
        this.secAnswers.add(secAnswer);
    }
    
    /**
     * 
     * Returns a String associated with secAnswer
     * 
     * @param idx int value that corresponds to a String in the ArrayList of Strings
     * @return String value stored in the ArrayList
     */
    public String getSecAnswer(int idx)
    {
        return this.secAnswers.get(idx);
    }
    
    /**
     * 
     * Returns String ArrayList associated with the secAnswers field
     * 
     * @return String ArrayList stored in the secAnswers field
     */
    public ArrayList<String> getAllSecAnswers()
    {
        ArrayList<String> secAnswerCopy = new ArrayList<>();
        for(String answer: this.secAnswers)
        {
            secAnswerCopy.add(answer);
        }
        return secAnswerCopy;
    }
    
    /**
     * 
     * Returns String ArrayList associated with the secAnswers field
     * 
     * @return String ArrayList stored in the secQuestions field
     */
    public ArrayList<String> getAllSecQuestions()
    {
        ArrayList<String> secQuestionCopy = new ArrayList<>();
        for(String question: this.secQuestions)
        {
            secQuestionCopy.add(question);
        }
        return secQuestionCopy;
    }
    public void setAllSecQuestions(ArrayList<String> secQ)
    {
        this.secQuestions = secQ;
    }
    public void setAllSecAnswers(ArrayList<String> secA)
    {
        this.secAnswers = secA;
    }
   
    
    /**
     * 
     * Sets all fields of InfoUnit at the same time
     * 
     * @param ident String identifier for the object
     * @param siteName String value for the siteName field
     * @param username String value for the username field
     * @param password String value for the password field
     * @param secQuestions String ArrayList for the secQuestions field
     * @param secAnswers String ArrayList for the secAnswers field
     */
     public void setAll(String ident, String siteName, String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        this.setIdent(ident);
        this.setUsername(username);
        this.setSiteName(siteName);
        this.setPassword(password);
        for (String question: secQuestions)
        {
            this.addSecQuestion(question);
        }
        for (String answer: secAnswers)
        {
            this.addSecAnswer(answer);
        }
    }
}
