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
public class StringConcatToStorage implements Observer{
    private StringConcater concat;
    private Storage storage;
    private StringCEvent event;
    
    public StringConcatToStorage(Storage storage, StringConcater concat)
    {
        this.concat = concat;
        this.storage = storage;
    }
    
    
    @Override
    public void logAndMakeChanges()
    {
        StringCEvent event = concat.getEvent();
        switch(event.getInfoChange())
        {
            case ITEM_CREATED:
                storage.setData(this.concat.concat());
                break;
            case ITEM_CHANGED:
                storage.overWriteEntry(this.concat.concat());
                break;
            case ITEM_DELETED:
                storage.eraseEntry(this.concat.concat());
                break;
            default:
                System.out.println("WUT");
        }
    }
}
