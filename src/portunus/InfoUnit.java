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
    public String username;
    public String password;
    public ArrayList<String> secQuestions;
    public ArrayList<String> secAnswers;
    public InfoUnit(String ident)
    {
        this.ident = ident;
        username = "";
        password = "";
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    public InfoUnit(String ident, String username, String password)
    {
        this.ident = ident;
        this.username = username;
        this.password = password;
        secQuestions = new ArrayList<>();
        secAnswers = new ArrayList<>();
    }
    public InfoUnit(String ident, String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        this.ident = ident;
        this.username = username;
        this.password = password;
        this.secQuestions = secQuestions;
        this.secAnswers = secAnswers;
    }
    public void setIdent(String ident)
    {
        this.ident = ident;
    }
    public String getIdent()
    {
        return ident;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return username;
    }
    public void addSecQuestion(String secQuestion)
    {
        this.secQuestions.add(secQuestion);
    }
    public String getSecQuestion(int idx)
    {
        return this.secQuestions.get(idx);
    }
    public void addSecAnswer(String secAnswer)
    {
        this.secAnswers.add(secAnswer);
    }
    public String getSecAnswer(int idx)
    {
        return this.secAnswers.get(idx);
    }
    public ArrayList<String> getAllSecAnswers()
    {
        ArrayList<String> secAnswerCopy = new ArrayList<>();
        for(String answer: this.secAnswers)
        {
            secAnswerCopy.add(answer);
        }
        return secAnswerCopy;
    }
    public ArrayList<String> getAllSecQuestions()
    {
        ArrayList<String> secQuestionCopy = new ArrayList<>();
        for(String question: this.secQuestions)
        {
            secQuestionCopy.add(question);
        }
        return secQuestionCopy;
    }
    public void setAll(String ident, String username, String password, ArrayList<String> secQuestions, ArrayList<String> secAnswers)
    {
        this.setIdent(ident);
        this.setUsername(username);
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
