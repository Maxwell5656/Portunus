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
public class StringConcater {
    private String ident; // This is how the unencrypted user info objects will be identified
    // this variable in each user info object will be unique (hopefully)
    // variable ident may not be needed as we construct the hashing function -Maxwell
    private String password;
    private String username;
    private ArrayList<String> secQuestions;
    private ArrayList<String> secAnswers;
    
    public StringConcater()
    {
        ident = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
    public void reset() // resets all inputs to empty values, so that no login info is left inside this object
    {
        ident = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
    public String Concat()
    {
        String concatedString; 
        concatedString = ident + "***" + password + "***" + username + "***";
        // for now, three asteriks in sequence shall divide each morsel of info
        // unlikely to appear in any password but will still need check for this at user entry.
        // if anyone has a better idea please send it my way -Maxwell
        for(String question: secQuestions)
        {
            concatedString += question + "***";
        }
        for(String answer: secAnswers)
        {
            concatedString += answer + "***";
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
    //
}
