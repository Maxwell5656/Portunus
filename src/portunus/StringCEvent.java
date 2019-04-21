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
public class StringCEvent {
    private InfoChange infoChange;
    
    /**
     * 
     * Observer skeleton function
     *  
     */
    public StringCEvent(InfoChange infoEvent)
    {
        this.infoChange = infoEvent;
    }
    
    /**
     * 
     * Observer skeleton function
     *  
     */
    public InfoChange getInfoChange()
    {
        return infoChange;
    }
}
