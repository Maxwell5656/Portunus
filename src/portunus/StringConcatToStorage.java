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
public class StringConcatToStorage implements Observer{
    private StringConcater concat;
    private Storage storage;
    private StringCEvent event;
    
    /**
     * 
     * Sends a concatenated String to Storage to be stored
     * 
     * @param storage Storage object used to store data
     * @param concat StringConcater object containing data to be stored
     */
    public StringConcatToStorage(Storage storage, StringConcater concat)
    {
        this.concat = concat;
        this.storage = storage;
    }
    
    
    /**
     * 
     * Logs changes as events
     * 
     */
    @Override
    public void logAndMakeChanges()
    {
        StringCEvent event = concat.getEvent();
        switch(event.getInfoChange())
        {
            case ITEM_CREATED:
                storage.setData(this.concat.concat());
                break;
            case ITEM_CHANGED:
                storage.overWriteEntry(this.concat.concat());
                break;
            case ITEM_DELETED:
                storage.eraseEntry(this.concat.concat());
                break;
            default:
                System.out.println("WUT");
        }
    }
}
