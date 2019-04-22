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
enum setStorChange
{
    USERPASS_SET, COSMETIC_SET
}
public class SettStorEvent {
    private setStorChange change;
    public SettStorEvent(setStorChange change)
    {
        this.change = change;
    }
    public setStorChange getChange()
    {
        return this.change;
    }
}
