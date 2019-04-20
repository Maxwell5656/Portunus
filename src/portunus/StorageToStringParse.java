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
public class StorageToStringParse implements Observer{
    private Storage store;
    private StringParser parse;
    private StorageEvent event;
    
    public StorageToStringParse(Storage store, StringParser parse)
    {
        this.store = store;
        this.parse = parse;
    }
    @Override
    public void logAndMakeChanges()
    {
        this.event = store.getEvent();
        storChange change = this.event.getChange();
        switch(change)
        {
            case LOADING_TO_INFO:
                String toParse = store.getStringByIdent(this.event.getIdent());
                parse.parseString(toParse);
                break;
            default: // LOADING_TO_INFO is the only event pertinent to StringParser
                break;
        }
    }
}
