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
public class DecToSettStorage implements Observer{
    private Decorator decor;
    private SettingStorage storage;
    private DecoratorEvent event;
    public DecToSettStorage(Decorator decor, SettingStorage storage)
    {
        this.decor = decor;
        this.storage = storage;
    }
    
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
