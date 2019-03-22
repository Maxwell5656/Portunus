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
    private String password;
    private String username;
    private ArrayList<String> secQuestions;
    private ArrayList<String> secAnswers;
    
    public StringParser() // initialize everything to empty values
    {
        ident = "";
        password = "";
        username = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    
    public void parseString(String info)
    //this function needs to be fixed. It always gives an index out of bounds exception upon testing
    //-Maxwell
    {
        String newIdent = "";
        String newPassword = "";
        String newUsername = "";
        String secQorA = "";
        // these will be copied into StringParser's values once these have been filled
        
        int idx = 0;
        while((info.charAt(idx) != '*')&&(idx < info.length()))
        {   
            newIdent = newIdent + info.charAt(idx);
            idx++;
        }
        while(idx < info.length()-1)
        {
            String key = info.substring(idx, idx+3);
            idx += 3;
            switch(key)
            {
                case "***":
                    while((info.charAt(idx) != '*')&&(idx < info.length()-1))
                        {   
                            newPassword = newPassword + info.charAt(idx);
                            idx++;
                        }
                    //this.getFieldFrom(info, newPassword, idx);
                break;
                case "**|":
                    while((info.charAt(idx) != '*')&&(idx < info.length()-1))
                        {   
                            newUsername = newUsername + info.charAt(idx);
                            idx++;
                        }
                    //this.getFieldFrom(info, newUsername, idx);
                break;
                case "*|*":
                    //this.getFieldFrom(info, secQorA, idx);
                    secQorA = "";
                    while((info.charAt(idx) != '*')&&(idx < info.length()-1))
                        {   
                            secQorA = secQorA + info.charAt(idx);
                            idx++;
                        }
                    this.addSecQuestion(secQorA);
                break;
                case "*||":
                    //this.getFieldFrom(info, secQorA, idx);
                    secQorA = "";
                    while((info.charAt(idx) != '*')&&(idx < info.length()-1))
                        {   
                            secQorA = secQorA + info.charAt(idx);
                            idx++;
                        }
                    this.addSecAnswer(secQorA);
                break;
                default:
                break;
            }
            this.setIdent(newIdent);
            this.setPassword(newPassword);
            this.setUsername(newUsername);
        }
    }
    private void getFieldFrom(String getFrom, String insertTo, int idx)
            //This function won't work unless we use pass by reference in the int, and we need to figure that out more
            //-Maxwell
    {
        String copyString = "";
        while((getFrom.charAt(idx) != '*')&&(idx < getFrom.length()))
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
    public ArrayList<String> getSecQuestionList()
    {
        return secQuestions;
    }
    
    public ArrayList<String> getSecAnswerList()
    {
        return secAnswers;
    }
}
