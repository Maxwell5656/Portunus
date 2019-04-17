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
    public InfoEvent event;
    
    
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
    private void sendToConcat()
    {
        String newIdent = this.event.ident;
        if (this.event.getEvent() != InfoChange.ITEM_DELETED) this.concat.setAll(newIdent, info.getUsername(newIdent), info.getPassword(newIdent), info.getAllSecQuestions(newIdent), info.getAllSecAnswers(newIdent));
        else this.concat.setAll(event.getDeleted().getIdent(), event.getDeleted().getUsername(), event.getDeleted().getPassword(), event.getDeleted().getAllSecQuestions(), event.getDeleted().getAllSecAnswers());
        //this really long line should set everything there is needed for concat
        //depending on how exactly this works this might be an empty entry.
        String concated = this.concat.concat(); // in the future this will instead notify an observer of StringConcat to return .concat() to Storage
        System.out.println(concated + "\n"); // this is for testing purposes
        // eventually this will notify storage to store
    }
}
