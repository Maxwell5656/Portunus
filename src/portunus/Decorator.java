/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package portunus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class Decorator {
    private Interface view;
    private ArrayList<Observer> observers;
    private DecoratorEvent lastEvent;
    //Constructor
    public Decorator()
    {
        observers = new ArrayList<>();
    }
    
    //-------------------------------------------------------
    //colorSet(JColorChooser, JPanel)
    //uses the input from the color chooser to set the 
    //background color for the panel
    //-------------------------------------------------------
    public void colorSet(Color interfaceColor, JPanel Panel) {
        
        Panel.setBackground(interfaceColor);
        
    }
    
    public void saveColor(Color interfaceColor)
    {
        this.lastEvent = new DecoratorEvent(interfaceColor);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
    
    public DecoratorEvent getEvent()
    {
        return this.lastEvent;
    }
    public void addObserver(Observer O)
    {
        observers.add(O);
    }
    
    //-------------------------------------------------------
    //fontSizeSet(String, JLabel or JButton or JList or JTextField)
    //uses the input from the font setting combo box to set the 
    //font size for the text in the object passed to it
    //-------------------------------------------------------
    
        //for labels
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
    
        //for buttons
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
    
            //for lists
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
        
        //for text fields
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
        
    public void saveFont(String sizeSetting)
    {
        this.lastEvent = new DecoratorEvent(sizeSetting);
        for(Observer observer: observers)
        {
            observer.logAndMakeChanges();
        }
    }
}
