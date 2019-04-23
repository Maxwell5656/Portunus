/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 *Set of ENUMS that determine which type of change occured
 * @author Maxwell
 */
enum InfoChange
    // These are the possible changes to Info, add more as needed -Maxwell
{
    ITEM_CREATED, ITEM_CHANGED, ITEM_DELETED, ITEM_LOADED
}
/**
 * Logs the important changes of an instance of Info
 * @author Maxwell
 */
public class InfoEvent {
    private final InfoChange change;
    // all three events shouldn't happen concurrently, so I'll just have one variable for now
    public final String ident;
    // since all things are ident specific, this is so that an ident is always provided
    private final InfoUnit toDelete;
    // this saves a copy of an object to be removed, so that it's contents can be hashed by StringConcater
    // this may seem convoluted but it ensures that the model finished updating before the view -Maxwell
   
    /**
     * 
     * Constructor that logs identifier of InfoUnit that changed
     * 
     * @param change InfoChange flags that a change occurs
     * @param ident String identifier to update to
     */
    public InfoEvent(InfoChange change, String ident)
    {
        this.change = change;
        this.ident = ident;
        this.toDelete = null;
    }
    
    /**
     * 
     * Updates the event queue that an item is being deleted
     * 
     * @param toDelete InfoUnit that is being deleted
     */
    public InfoEvent(InfoUnit toDelete)
    // This is the constructor to call if an item is being deleted
    {
        this.change = InfoChange.ITEM_DELETED;
        this.ident = null;
        this.toDelete = toDelete;
    }
    
    /**
     * 
     * Gets the type of event that occured.
     * 
     * @return InfoChange object specifying the event
     */
    public InfoChange getEvent()
    {
        return change;
    }
    
    /**
     * 
     * Returns the instance of InfoUnit that is being deleted
     * 
     * @return InfoUnit that is being deleted
     */
    public InfoUnit getDeleted()
    {
        return toDelete;
    }
}
