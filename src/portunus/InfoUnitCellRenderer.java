/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Custom CellRenderer, Subclass of JLabel to graphically represent the view's list of InfoUnits
 * @author Maxwell
 */
public class InfoUnitCellRenderer extends JLabel implements ListCellRenderer<InfoUnit> {
    /**
     * Specifies the methods by which a JList of InfoUnits shall be represented
     * @param list JList of InfoUnits
     * @param value specific InfoUnit
     * @param index integer index
     * @param isSelected boolean determining if object is selected
     * @param cellHasFocus boolean
     * @return the JLabel to be used as graphical representation
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends InfoUnit> list, InfoUnit value, int index, boolean isSelected, boolean cellHasFocus)
    {
        this.setText(value.getSiteName());

         Color background;
         Color foreground;

         // check if this cell represents the current DnD drop location
         JList.DropLocation dropLocation = list.getDropLocation();
         if (dropLocation != null
                 && !dropLocation.isInsert()
                 && dropLocation.getIndex() == index) {

             background = new Color(0, 120, 215);
             foreground = Color.BLACK;

         // check if this cell is selected
         } else if (isSelected) {
             background = new Color(0,120,215);
             foreground = new Color(0, 120, 215);

         // unselected, and not the DnD drop location
         } else {
             background = Color.RED;
            foreground = Color.BLACK;
         };

        this.setBackground(background);
        this.setForeground(foreground);

         return this;
    }
}
