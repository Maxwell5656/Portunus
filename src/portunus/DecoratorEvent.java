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
 * Set of Enums that determine whether or not a color or a font setting is being saved
 * @author Maxwell
 */
enum decChange
{
    COLOR_CHANGE, FONT_CHANGE
}
/**
 * Logs the last element from an instance of Decorator primed to be saved.
 * @author Maxwell
 */
public class DecoratorEvent {
    private Color colorToSave;
    private String fontToSave;
    private decChange change;
    /**
     * Constructor that logs a Color to be saved.
     * @param toSave the instance of Color whose values will be saved.
     */
    public DecoratorEvent(Color toSave)
    {
        this.colorToSave = toSave;
        change = COLOR_CHANGE;
    }
    /**
     * Constructor that specifies a string to save, which will identify the font setting
     * @param toSave identifying string to be saved
     */
    public DecoratorEvent(String toSave)
    {
        this.fontToSave = toSave;
        this.change = FONT_CHANGE;
    }
    /**
     * Returns the Color that will be saved.
     * @return the instance of Color to be saved.
     */
    public Color getColor()
    {
        return this.colorToSave;
    }
    /**
     * Returns the identifying string to be saved
     * @return the identifying string
     */
    public String getFont()
    {
        return this.fontToSave;
    }
    /**
     * Returns the enum specifying the type of info to be saved
     * @return the decChange value
     */
    public decChange getChange()
    {
        return change;
    }
}
