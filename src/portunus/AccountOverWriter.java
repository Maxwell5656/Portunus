/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.util.ArrayList;

/**
 * Controller class that allows a user to change contents of an existing infoUnit log from the view.
 * @author Maxwell
 */
public class AccountOverWriter {
    //controller class that overwrites accounts in info
    private Info info;
    /**
     * Instantiates an instance of AccountOverWriter given a reference to the Info object on which it will act.
     * @param info The specific instance of Info on which this class operates.
     */
    public AccountOverWriter(Info info)
    {
        this.info = info;
    }
    /**
     * Alters the contents of an InfoUnit object within info, given an identifying string and a set of existing and/or new fields.
     * @param ident The identifying string of the InfoUnit object whose fields will be overwritten
     * @param siteName The new website associated with the logged account.
     * @param username The new username of the logged account.
     * @param password The new password of the logged account.
     * @param secQ The new set of security questions associated with the logged account
     * @param secA The new set of security answers associated with the logged account
     */
    public void overWrite(String ident, String siteName, String username, String password, ArrayList<String> secQ, ArrayList<String> secA)
    {
        info.setSiteName(siteName, ident);
        info.setUsername(username, ident);
        info.setPassword(password, ident);
        info.setAllSecQuestions(secQ, ident);
        info.setAllSecAnswers(secA, ident);
    }
}
