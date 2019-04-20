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
    
    public StringPEvent(storChange event)
    {
        this.event = event;
    }
    public storChange getEvent()
    {
        return this.event;
    }
}
