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
public class StringPEvent {
    private storChange event;
    
    /**
     * 
     * Waits for StringParser to change related to Storage
     * 
     * @param event storChange observer that is updating 
     */
    public StringPEvent(storChange event)
    {
        this.event = event;
    }
    
    /**
     * 
     * Gets the current event
     * 
     * @return storChange changed storage observer event
     */
    public storChange getEvent()
    {
        return this.event;
    }
}
