/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package portunus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Provides the methods by which the view is changed upon user command or info loaded by SettingStorage
 * @author Maxwell
 */
public class Decorator {
    private Interface view;
    private ArrayList<Observer> observers;
    private DecoratorEvent lastEvent;
    /**
     * Creates a new instance of Decorator, allocating space for observers to observe Decorator.
     */
    public Decorator()
    {
        observers = new ArrayList<>();
    }
    
    /**
     * Sets the color of a given JPanel given an instance of Color.
     * @param interfaceColor The Color that Panel's background will be set to.
     * @param Panel The JPanel whose color will be changed
     */
    public void colorSet(Color interfaceColor, JPanel Panel) {
        
        Panel.setBackground(interfaceColor);
        
    }
    /**
     * Saves a given color to any instance of DecToSettStorage set to observe this Decorator
     * @param interfaceColor the color to be saved
     */
    public void saveColor(Color interfaceColor)
    {
        this.lastEvent = new DecoratorEvent(interfaceColor);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
    /**
     * Gets the last instance of DecoratorEvent created to log the last color saved
     * @return an instance of DecoratorEvent logging the last color saved
     */
    public DecoratorEvent getEvent()
    {
        return this.lastEvent;
    }
    /**
     * Sets an applicable observer class to observe this instance.
     * @param O The observer to add to Decorator's list of observers.
     */
    public void addObserver(Observer O)
    {
        observers.add(O);
    }
    
    /**
     * Sets a given JLabel's font size based on a selecting String.
     * @param sizeSetting the String that determines the size to set.
     * @param text The Jlabel that will have it's font size changed.
     */
    public void fontSizeSet(String sizeSetting, JLabel text) {
        if(sizeSetting.equals("Extra Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 12));
        }
        if(sizeSetting.equals("Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 16));
        }
        if(sizeSetting.equals("Normal")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 24));
        }
        if(sizeSetting.equals("Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 34));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 40));
        }
    }
    
    /**
     * Sets a given JButton's font size based on a selecting String.
     * @param sizeSetting the String that determines the size to set.
     * @param text The JButton that will have it's font size changed.
     */
    public void fontSizeSet(String sizeSetting, JButton text) {
        if(sizeSetting.equals("Extra Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 12));
        }
        if(sizeSetting.equals("Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 16));
        }
        if(sizeSetting.equals("Normal")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 24));
        }
        if(sizeSetting.equals("Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 34));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 40));
        }
    }
    
    /**
     * Sets a given JList's font size based on a selecting String.
     * @param sizeSetting the String that determines the size to set.
     * @param text The JList that will have it's font size changed.
     */    
    public void fontSizeSet(String sizeSetting, JList text) {
        if(sizeSetting.equals("Extra Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 12));
        }
        if(sizeSetting.equals("Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 16));
        }
        if(sizeSetting.equals("Normal")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 24));
        }
        if(sizeSetting.equals("Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 34));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 40));
        }
    }
        
    /**
     * Sets a given JTextField's font size based on a selecting String.
     * @param sizeSetting the String that determines the size to set.
     * @param text The JTextField that will have it's font size changed.
     */
    public void fontSizeSet(String sizeSetting, JTextField text) {
        if(sizeSetting.equals("Extra Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 12));
        }
        if(sizeSetting.equals("Small")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 16));
        }
        if(sizeSetting.equals("Normal")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 24));
        }
        if(sizeSetting.equals("Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 34));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 40));
        }
    }
        
    /**
     * Saves the given selecting string to any listening observers
     * @param sizeSetting The string that will be logged in a DecoratorEvent, priming it to be saved.
     */
    public void saveFont(String sizeSetting)
    {
        this.lastEvent = new DecoratorEvent(sizeSetting);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
