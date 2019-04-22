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
public class AccountDeleter {
    //Controller class that deletes account from view
    private Info info;
    
    public AccountDeleter(Info info)
    {
        this.info = info;
    }
    public void delete(String identToDelete)
    {
        info.deleteInfoUnit(identToDelete);
    }
}
