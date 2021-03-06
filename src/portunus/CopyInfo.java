/*
 * CopyInfo class copies user info to the system clipboard
 */
package portunus;

import java.awt.*;
import java.awt.datatransfer.*;
import javafx.scene.input.ClipboardContent;

public class CopyInfo {
    public void copy() {}
    
    //-----------------------------------------------------------
    //CopyInfo.copy(String)
    //copies the passed string to the system clipboard
    //-----------------------------------------------------------
    
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
