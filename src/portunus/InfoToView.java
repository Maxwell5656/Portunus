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
public class InfoToView implements Observer{
    //This class is responsible for handling changes the view needs to record, such as new InfoUnits, deleted InfoUnits, etc.
    private Interface view;
    private Info info;
    
    @Override
    public void logAndMakeChanges()
    {
        
    }
}
