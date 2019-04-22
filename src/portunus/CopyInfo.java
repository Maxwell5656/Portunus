/*

 * CopyInfo class copies user info to the system clipboard

 */

package portunus;



import java.awt.*;

import java.awt.datatransfer.*;

import javafx.scene.input.ClipboardContent;



public class CopyInfo {

    public void CopyInfo() {}

    

    //-----------------------------------------------------------

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