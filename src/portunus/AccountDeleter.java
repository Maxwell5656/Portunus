/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 * 
 * @author Maxwell
 * Controller class that serves as a way for user to remove InfoUnit logs from the view
 */
public class AccountDeleter {
    //C
    private Info info;
    /**
     * Constructor that requires an instance of Info on which it deletes objects.
     * @param info the instance of Info on which to act
     */
    public AccountDeleter(Info info)
    {
        this.info = info;
    }
    /**
     * Removes an instance of InfoUnit from info given InfoUnit's four character identifying string
     * @param identToDelete the identifying string of the desired log to delete, retrieved from user input
     */
    public void delete(String identToDelete)
    {
        info.deleteInfoUnit(identToDelete);
    }
}
