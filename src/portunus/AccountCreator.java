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
public class AccountCreator {
    // This controller class acts as intermediary between view (interface) and model (info), creating account on button press
    private Interface view;
    private Info info;
    private String ident;
    
    /**
     * 
     *  Links AccountCreator object to a view and an Info object
     * 
     * @param view Interface to be linked
     * @param info Info object to be linked
     */
    public AccountCreator(Interface view, Info info)
    {
        this.view = view;
        this.info = info;
    }
    
    /**
     * 
     * Updates the user's login information from the view
     * 
     * @param accountName String name for account
     * @param username String username
     * @param password String password
     * @param secQ ArrayList of values to be stored
     * @param secA ArrayList of values to be stored
     */
    public void createAccount(String accountName, String username, String password, ArrayList<String> secQ, ArrayList<String> secA)
    {
        info.createInfoUnit(username, accountName, password, secQ, secA);
    }
}
