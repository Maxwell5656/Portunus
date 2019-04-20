/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 *
 * @author Maxwell
 */
public class AccountCreater {
    // This controller class acts as intermediary between view (interface) and model (info), creating account on button press
    private Interface view;
    private Info info;
    private String ident;
    
    public AccountCreater(Interface view, Info info)
    {
        this.view = view;
        this.info = info;
    }
    
    //public void createAccount()
}
