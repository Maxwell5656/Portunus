/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 * Observer class that passes an instance of Decorator's changes and actions to an instance of SettingStorage
 * @author Maxwell
 */
public class DecToSettStorage implements Observer{
    private Decorator decor;
    private SettingStorage storage;
    private DecoratorEvent event;
    /**
     * Creates a new instance of DecToSettStorage, requiring an observee and a class to notify
     * @param decor the Decorator class to observe
     * @param storage the SettingStorage class to notify of any changes
     */
    public DecToSettStorage(Decorator decor, SettingStorage storage)
    {
        this.decor = decor;
        this.storage = storage;
    }
    /**
     * Gets the latest event of the observed Decorator, which informs the fields to be saved by the notified SettingStorage
     */
    public void logAndMakeChanges()
    {
        this.event = this.decor.getEvent();
        switch(this.event.getChange())
        {
            case COLOR_CHANGE:
                this.storage.setColor(this.event.getColor());
                break;
            case FONT_CHANGE:
                this.storage.setFontSize(this.event.getFont());
                break;
            default:
                break;
        }
    }
}
