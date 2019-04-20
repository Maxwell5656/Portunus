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
enum storChange
{
    ITEM_ADDED, ITEM_REMOVED, SAVE_SUCCESSFUL, LOADING_TO_INFO
    //ITEM_ADDED: marks a successful use of setData
    //ITEM_REMOVED: marks successful removal of item
    //SAVE_SUCCESSFUL: marks successful overwrite (since the info will already be in view, this will only really be 
    //for a short message in view ("Saved successful!" or something))
    //LOADING_TO_INFO: marks the creation of info items given saved data (won't require changedIdent field).
}
public class StorageEvent {
    private storChange change; // the type of change
    private String changedIdent; // the ident that changed (applicable only to first three enum types
    
    public StorageEvent(storChange change, String ident)
    {
        this.change = change;
        changedIdent = ident;
    }
    public storChange getChange()
    {
        return this.change;
    }
    public String getIdent()
    {
        return changedIdent;
    }
}
