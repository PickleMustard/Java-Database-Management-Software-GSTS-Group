
//package iaproject.ProgramStream;


import java.awt.Dimension;
import java.awt.Toolkit;

// Purpose: The main method for the Deal Tracker to open the opening window

public class BootUp {

    public static void main(String[] args) {
        //Todo:
        /* 
        Create the GUI for selection
        Create the window for selection on the table
        Create the class to access the database
        Create the class to add to the database
        Create class to modify data in database
        Create class to delete data in database
        Create object to display errors when gotten
        Create window to display selected information
        Create an administrator pop-up
        
        */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width/2;
        int centerY = screenSize.height/2;
        InitialWindow initialWindow = new InitialWindow((centerX-480) , (centerY-320) , 960, 640, "");
    }
    
}
 