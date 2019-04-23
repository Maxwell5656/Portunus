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
 * Observer class that notifies a StringConcater of changes of an observed Info.
 * @author Maxwell
 */
public class InfoToStringConcat implements Observer {
    // this class will notify StringConcater of changes to Info, hence the name;
    private StringConcater concat;
    private Info info; // pointers to Info and StringConcater so that all required functions can be called
    public InfoEvent event;
    
    /**
     * 
     * Constructor that specifies the concat to notify and the info to observe.
     * 
     * @param concat StringConcater to be updated with information
     * @param info Info object to be used as the source of info
     */
    public InfoToStringConcat(StringConcater concat, Info info)
    // pointers must be provided on startup as part of this object's contract. As otehrwise it would be useless
    //-Maxwell
    {
        this.concat = concat;
        this.info = info;
    }
    
    /**
     * 
     * Checks to see if changes have been made 
     * 
     */
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
                break;
            }
            case ITEM_CHANGED:
            {
                this.sendToConcat();
                break;
                //The only difference this will likely have with ITEM_CREATED case is how
                //the notification to view is handled
            }
            case ITEM_DELETED:
            {
                this.sendToConcat();
                break;
                //TODO: add some kind of message to Concater that this is for deletion
            }
            default:
                System.out.println("ERROR: Invalid InfoEvent\n");
        }
    }
    
    /**
     * 
     * Sends all the information from a given InfoUnit object to be concatenated into a string
     * 
     */
    private void sendToConcat()
    {
        String newIdent = this.event.ident;
        if (this.event.getEvent() != InfoChange.ITEM_DELETED) this.concat.setAll(newIdent, info.getSiteName(newIdent), info.getUsername(newIdent), info.getPassword(newIdent), info.getAllSecQuestions(newIdent), info.getAllSecAnswers(newIdent));
        else this.concat.setAll(event.getDeleted().getIdent(), event.getDeleted().getSiteName(), event.getDeleted().getUsername(), event.getDeleted().getPassword(), event.getDeleted().getAllSecQuestions(), event.getDeleted().getAllSecAnswers());
        //this really long line should set everything there is needed for concat
        //depending on how exactly this works this might be an empty entry.
        concat.logEvent(new StringCEvent(this.event.getEvent()));
        // eventually this will notify storage to store
    }
}
