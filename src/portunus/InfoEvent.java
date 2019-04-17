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
enum InfoChange //TODO: check this against java naming conventions
    // These are the possible changes to Info, add more as needed -Maxwell
{
    ITEM_CREATED, ITEM_CHANGED, ITEM_DELETED
}
public class InfoEvent {
    private final InfoChange change;
    // all three events shouldn't happen concurrently, so I'll just have one variable for now
    public final String ident;
    // since all things are ident specific, this is so that an ident is given.
    public InfoEvent(InfoChange change, String ident)
    {
        this.change = change;
        this.ident = ident;
    }
    public InfoChange getEvent()
    {
        return change;
    }
}
