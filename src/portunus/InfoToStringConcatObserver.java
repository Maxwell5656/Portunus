/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import static portunus.InfoChange.ITEM_CREATED;
import static portunus.InfoChange.ITEM_CHANGED;
import static portunus.InfoChange.ITEM_DELETED;

/**
 *
 * @author Maxwell
 */
public class InfoToStringConcatObserver implements Observer {
    // this class will notify StringConcater of changes to Info, hence the name;
    private StringConcater concat;
    private Info info; // pointers to Info and StringConcater so that all required functions can be called
    private InfoEvent event;
    
    
    public InfoToStringConcatObserver(StringConcater concat, Info info)
    // pointers must be provided on startup as part of this object's contract. As otehrwise it would be useless
    //-Maxwell
    {
        this.concat = concat;
        this.info = info;
    }
    
    @Override
    public void logAndMakeChanges()
    {
        this.event = info.getEvent();
        switch(this.event.getEvent())
        {
            case ITEM_CREATED:
            // until InfoToViewObserver is implemented then this will likely be same as other.
            {
                this.sendToConcat();
            }
            case ITEM_CHANGED:
            {
                this.sendToConcat();
                //The only difference this will likely have with ITEM_CREATED case is how
                //the notification to view is handled
            }
            case ITEM_DELETED:
            {
                this.sendToConcat();
                //TODO: add some kind of message to Concater that this is for deletion
            }
            default:
                System.out.println("ERROR: Invalid InfoEvent\n");
        }
    }
    private void sendToConcat()
    {
        String newIdent = this.event.ident;
        this.concat.setAll(newIdent, info.getUsername(newIdent), info.getPassword(newIdent), info.getAllSecQuestions(newIdent), info.getAllSecAnswers(newIdent));
        //this really long line should set everything there is needed for concat
        //depending on how exactly this works this might be an empty entry.
        this.concat.Concat();
        // eventually this will notify storage to store
    }
}
