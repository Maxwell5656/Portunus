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
 *
 * @author Maxwell
 */
public class InfoUnitCellRenderer extends JLabel implements ListCellRenderer<InfoUnit> {
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
