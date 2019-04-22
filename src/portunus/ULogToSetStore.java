/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.util.ArrayList;

/**
 *
 * @author Maxwell
 */
public class ULogToSetStore implements Observer {
    private UserLogin loginer;
    private SettingStorage store;
    
    public ULogToSetStore(UserLogin loginer, SettingStorage store)
    {
        this.loginer = loginer;
        this.store = store;
    }
    @Override
    public void logAndMakeChanges()
    {
        this.store.setPassword(this.loginer.getPassword(0x4EED), 0x4EED);
        this.store.setUsername(this.loginer.getUsername(0x4EED), 0x4EED);
    }
}
