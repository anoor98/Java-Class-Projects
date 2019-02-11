import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import java.io.File;
import java.util.Scanner;

public class FileMenu implements ActionListener {

    // Save the reference to the gui object this FileMenu is 
    // associated with
    private Date212GUI gui;
   
    // Constructor that takes as its paramaeter the gui associated 
    // with this FileMenu
    public FileMenu(Date212GUI gui) {
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        // Get the command name from the event
        String menuName = event.getActionCommand();
        

        if (menuName.equals("Open")) {
            
            // Create the object that will choose the file
            JFileChooser fc = new JFileChooser();

            // Attempt to open the file
            int returnVal = fc.showOpenDialog(null);

            // If user selected a file, create File object and pass it to
            // the gui's readFile method
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = fc.getSelectedFile();
                try {
					this.gui.readFile(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
            } 
            else if (returnVal == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("Open command cancelled by user.");
            }
        } 
        else if (menuName.equals("Quit"))
        {
            JOptionPane.showMessageDialog(null,"You clicked on Quit");
            System.exit(1);
        } 
    }			
	 
}
