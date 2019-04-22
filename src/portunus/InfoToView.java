/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import javax.swing.JList;

/**
 *
 * @author Maxwell
 */
public class InfoToView implements Observer{
    //This class is responsible for handling changes the view needs to record, such as new InfoUnits, deleted InfoUnits, etc.
    private Interface view;
    private Info info;
    private InfoEvent event;
    
    public InfoToView(Info info, Interface view)
    {
        this.view = view;
        this.info = info;
    }
    
    @Override
    public void logAndMakeChanges()
    {
        this.event = info.getEvent();
        switch(event.getEvent())
        {
            case ITEM_CREATED:
                //view.createThing(this.event.ident....)
                System.out.println("This seems to work?");
                //view.testThis();
                break;
            case ITEM_CHANGED:
                break;
            case ITEM_DELETED:
                //view.deleteThing(this.event.ident....)
        }
    }
}
