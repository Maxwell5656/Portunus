/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.*;
import java.awt.datatransfer.*;
import javafx.scene.input.ClipboardContent;
public class CopyInfo {
/*
* CopyInfo class copies user info to the system clipboard
*/
    public void CopyInfo() {}
    //------------------------------------------------------------
    //CopyInfo.copy(String)
    //copies the passed string to the system clipboard
    //-----------------------------------------------------------
    public void copy(String info) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        StringSelection contents = new StringSelection(info);
        content.putString("Some text");
        clipboard.setContents(contents, null);
    }
}
