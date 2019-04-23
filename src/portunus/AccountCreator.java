/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;


/**
 * This class serves as part of the controller, allowing a user to create new InfoUnit logs
 * from the view.
 * 
 */
public class AccountCreator 

{
    // This controller class acts as intermediary between view (interface) and model (info), creating account on button press
    private Info info;
    private String ident;
    private InfoToView infoToView;
    public AccountCreator(Info info)
    /**
     * 
     *  Links AccountCreator object to a view and an Info object
     * 
     * @param view Interface to be linked
     * @param info Info object to be linked
     */
    {
        this.info = info;
    }
public void createAccount(DefaultListModel listModel, String accountName, String username, String password, ArrayList<String> secQ, ArrayList<String> secA)
    /**
     * 
     * Updates the user's login information from the view, adding data to be placed within Info
     * 
     * @param accountName String name for account
     * @param username String username
     * @param password String password
     * @param secQ ArrayList of values to be stored
     * @param secA ArrayList of values to be stored
     */
    {
        
        info.createInfoUnit(username, accountName, password, secQ, secA);
        //The following line won't work and I don't know why
        //infoToView.createItem(listModel, accountName);
        listModel.addElement(accountName);
    }
    
    
}
