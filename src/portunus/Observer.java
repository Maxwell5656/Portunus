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
public interface Observer {
    public void logAndMakeChanges();
    // this will get an event object and then make changes based on that event object. The event object will
    // have to be stored in the observed class first because java is a butt -Maxwell
}
