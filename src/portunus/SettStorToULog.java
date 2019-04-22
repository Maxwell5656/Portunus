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
public class SettStorToULog implements Observer {
    private SettingStorage store;
    private UserLogin loginer;
    private SettStorEvent event;
    
    public SettStorToULog(SettingStorage store, UserLogin loginer)
    {
        this.store = store;
        this.loginer = loginer;
    }
    public void logAndMakeChanges()
    {
        this.event = store.getEvent();
        switch(this.event.getChange())
        {
            case USERPASS_SET:
                this.loginer.setLoginInfo(this.store.getUsername(0x4EED),this.store.getPassword(0x4EED));
                break;
            case COSMETIC_SET:
                break;
            default:
                break;
        }
    }
}
