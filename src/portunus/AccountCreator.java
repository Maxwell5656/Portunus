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
 *
 * @author Maxwell
 */
public class AccountCreator {
    // This controller class acts as intermediary between view (interface) and model (info), creating account on button press
    private Info info;
    private String ident;
    private InfoToView infoToView;
    
    public AccountCreator(Info info)
    {
        this.info = info;
    }
    
    public void createAccount(DefaultListModel listModel, String accountName, String username, String password, ArrayList<String> secQ, ArrayList<String> secA)
    {
        
        info.createInfoUnit(username, accountName, password, secQ, secA);
        //The following line won't work and I don't know why
        //infoToView.createItem(listModel, accountName);
        listModel.addElement(accountName);
    }
    
    
}
