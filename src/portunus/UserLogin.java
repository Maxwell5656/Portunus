/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.util.ArrayList;

/**
 *
 * @author sgoug
 */
public class UserLogin {
    //TODO: Make UserLogin Class
    private String username;
    private String password;
    private final int KEY = 0x4EED;
    private ArrayList<Observer> observers;

    public UserLogin()
    {
        this.observers = new ArrayList<>();
    }
    public void setLoginInfo(String username, String password)
    {
        this.username =  username;
        this.password = password;
        this.logEvent();
    }
    public boolean verifyCredentials(String username, String password)
    {
        return (this.username == null ? username == null : this.username.equals(username))&&(this.password == null ? password == null : this.password.equals(password));
    }
    public String getUsername(int key)
    {
        if(key == this.KEY) return username;
        else return null;
    }
    public String getPassword(int key)
    {
        if(key == this.KEY) return password;
        else return null;
    }
    public void addObserver(Observer O)
    {
        this.observers.add(O);
    }
    public void logEvent()
    {
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
