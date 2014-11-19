package virtualzoo.ui;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExampleFrame extends JFrame {
    
    private JTextField nameField;
    private JButton myButton2, myButton3, myButton4, myButton5; 
    
    public ExampleFrame() {
        super("My Application");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setSize(300, 200);
        
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        //setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns
        //setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns
        //setLayout(new GridLayout(2, 3, 20, 20)); // 2 rows, 3 columns, 20 pixel gap
        setLayout(new BorderLayout());
        
        // Create a panel to hold the components
        JPanel panel = new JPanel(new BorderLayout());
        
        // Create the components and add to the panel
        //JButton myButton = new JButton("North");
        //panel.add(myButton, BorderLayout.NORTH);
        
        JPanel nameEntryPanel = new JPanel(); // defaults to FlowLayout
        
        JLabel nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(15);
        
        nameEntryPanel.add(nameLabel);
        nameEntryPanel.add(nameField);
        
        panel.add(nameEntryPanel, BorderLayout.NORTH);
        
        myButton2 = new JButton("South");
        panel.add(myButton2, BorderLayout.SOUTH);
        
        myButton3 = new JButton("East");
        panel.add(myButton3, BorderLayout.EAST);
        
        myButton4 = new JButton("West");
        myButton4.addActionListener(new WestButtonHandler());
        panel.add(myButton4, BorderLayout.WEST);
        
        myButton5 = new JButton("Center");
        myButton5.addActionListener(new CenterButtonHandler());
        panel.add(myButton5, BorderLayout.CENTER);
        
        // Add the panel to the frame
        add(panel); // defaults to BorderLayout.CENTER
        
        pack();
    }
    
    
    private class CenterButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Hello " + nameField.getText());
        }
    }
    
    private class WestButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Hello " + nameField.getText().toUpperCase());
        }
    }
    
}
