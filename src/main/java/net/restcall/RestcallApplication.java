package net.restcall;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RestcallApplication {


    public static void main(String[] args) {
        // Create a JFrame (the main window)
        JFrame frame = new JFrame("Main Window");
        
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the size of the window
        frame.setSize(400, 300);
        
        // Create a label to add to the frame
        JLabel label = new JLabel("Hello, World!");
        
        // Add the label to the frame
        frame.add(label);
        
        // Set the frame visibility
        frame.setVisible(true);
    }
}
