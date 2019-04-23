/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import javax.swing.JList;

/**
 *Observer class that notifies the view of changes to Info
 * @author Maxwell
 */
public class InfoToView implements Observer{
    //This class is responsible for handling changes the view needs to record, such as new InfoUnits, deleted InfoUnits, etc.
    private Interface view;
    private Info info;
    private InfoEvent event;
    /**
     * Constructor that specifies an Info to observe and a View to notify
     * @param info instance of Info to be observed
     * @param view instance of Interface to notify of changes
     */
    public InfoToView(Info info, Interface view)
    {
        this.view = view;
        this.info = info;
}
    /**
     * 
     * Checks for changes in Info to update view
     * 
     */
    @Override
    public void logAndMakeChanges()
    {
        this.event = info.getEvent();
        String ident = this.event.ident;
        switch(event.getEvent())
        {
            case ITEM_LOADED:
                view.addInfoUnit(ident, info.getSiteName(ident), info.getUsername(ident), info.getPassword(ident), info.getAllSecQuestions(ident), info.getAllSecAnswers(ident));
                break;
            case ITEM_CREATED:
                view.addInfoUnit(ident, info.getSiteName(ident), info.getUsername(ident), info.getPassword(ident), info.getAllSecQuestions(ident), info.getAllSecAnswers(ident));
                break;
            case ITEM_CHANGED:
                break;
            case ITEM_DELETED:
                view.removeInfoUnit(this.event.getDeleted().getIdent());
                break;
        }
    }
}
