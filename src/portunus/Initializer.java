/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Maxwell
 */
public class Initializer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Info info = new Info();
        UserLogin loginer = new UserLogin();
        SettingStorage store = new SettingStorage("SettingsStorage.txt");
        loginer.addObserver(new ULogToSetStore(loginer, store));
        store.addObserver(new SettStorToULog(store, loginer));
        Decorator decor = new Decorator();
        decor.addObserver(new DecToSettStorage(decor, store));
        store.loadSettings();
        //loginer.setLoginInfo("pi", "x");
        
        
        // in this code, the interface is created
        // note how the interface creation is inside of run()
        // it seems that this is needed for the buttons to display the correct look and feel of the buttons
        // could possibly move this into the function call, since all that is needed for info and decorator to connect
        try {
            for (javax.swing.UIManager.LookAndFeelInfo infoo : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(infoo.getName())) {
                    javax.swing.UIManager.setLookAndFeel(infoo.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Interface view = new Interface();
                    view.addAccountCreator(new AccountCreator(info));
                    info.addObserver(new InfoToView(info, view));
                    view.addAccountDeleter(new AccountDeleter(info));
                    view.addUserLogin(loginer);
                    view.addDecorator(decor);
                    view.changeCosmetics(store.getColor(), store.getFontSize());
                    view.accountExists(store);
                    view.addAccountOverWriter(new AccountOverWriter(info));
                    view.setVisible(true);
                    
                    
                }
            });
    }
}
