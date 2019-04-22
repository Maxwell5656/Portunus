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
public class AccountOverWriter {
    //controller class that overwrites accounts in info
    private Info info;
    public AccountOverWriter(Info info)
    {
        this.info = info;
    }
    public void overWrite(String ident, String siteName, String username, String password, ArrayList<String> secQ, ArrayList<String> secA)
    {
        info.setSiteName(siteName, ident);
        info.setUsername(username, ident);
        info.setPassword(password, ident);
        info.setAllSecQuestions(secQ, ident);
        info.setAllSecAnswers(secA, ident);
    }
}
