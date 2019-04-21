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
public class InfoToView implements Observer{
    //This class is responsible for handling changes the view needs to record, such as new InfoUnits, deleted InfoUnits, etc.
    private Interface view;
    private Info info;
    private InfoEvent event;
    
    /**
     * 
     * Checks for changes in Info to update view
     * 
     */
    @Override
    public void logAndMakeChanges()
    {
        this.event = info.getEvent();
        switch(event.getEvent())
        {
            case ITEM_CREATED:
                //view.createThing(this.event.ident....)
                break;
            case ITEM_CHANGED:
                break;
            case ITEM_DELETED:
                //view.deleteThing(this.event.ident....)
        }
        
    }
}
