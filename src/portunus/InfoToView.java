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
        String ident = this.event.ident;
        switch(event.getEvent())
        {
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
