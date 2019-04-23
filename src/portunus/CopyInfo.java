/*
 * CopyInfo class copies user info to the system clipboard
 */
package portunus;

import java.awt.*;
import java.awt.datatransfer.*;
import javafx.scene.input.ClipboardContent;
/**
 * Provides the methods by which account info will be copied to the clipboard
 * @author Sarah
 */
public class CopyInfo {
    /**
     * Instantiates an instance of CopyInfo. No fields required.
     */
    public void copy() {}
    
    /**
     * 
     * Copies passed string into the clipboard
     * 
     * @param info String to be copied
     */
    public void copy(String info) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        ClipboardContent content = new ClipboardContent();
        StringSelection contents = new StringSelection(info);
        content.putString("Some text");
        clipboard.setContents(contents, null);
    }
}
