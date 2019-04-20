/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package portunus;

import javax.swing.*;
import java.awt.*;

public class Decorator {
    //Constructor
    Decorator(){}
    
    //-------------------------------------------------------
    //colorSet(JColorChooser, JPanel)
    //uses the input from the color chooser to set the 
    //background color for the panel
    //-------------------------------------------------------
    public void colorSet(JColorChooser colorPicker, JPanel Panel) {
        Color interfaceColor;
        interfaceColor = colorPicker.getColor();
        Panel.setBackground(interfaceColor);
        
    }
    
    //Font size
    
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
            text.setFont(new Font("Agency FB", Font.BOLD, 36));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 48));
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
            text.setFont(new Font("Agency FB", Font.BOLD, 36));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 48));
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
            text.setFont(new Font("Agency FB", Font.BOLD, 36));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 48));
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
            text.setFont(new Font("Agency FB", Font.BOLD, 36));
        }
        if(sizeSetting.equals("Extra Large")) {
            text.setFont(new Font("Agency FB", Font.BOLD, 48));
        }
    }
}
