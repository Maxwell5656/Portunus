/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.awt.Color;
import static portunus.decChange.COLOR_CHANGE;
import static portunus.decChange.FONT_CHANGE;

/**
 *
 * @author Maxwell
 */
enum decChange
{
    COLOR_CHANGE, FONT_CHANGE
}

public class DecoratorEvent {
    private Color colorToSave;
    private String fontToSave;
    private decChange change;
    
    public DecoratorEvent(Color toSave)
    {
        this.colorToSave = toSave;
        change = COLOR_CHANGE;
    }
    
    public DecoratorEvent(String toSave)
    {
        this.fontToSave = toSave;
        this.change = FONT_CHANGE;
    }
    
    public Color getColor()
    {
        return this.colorToSave;
    }
    public String getFont()
    {
        return this.fontToSave;
    }
    public decChange getChange()
    {
        return change;
    }
}
