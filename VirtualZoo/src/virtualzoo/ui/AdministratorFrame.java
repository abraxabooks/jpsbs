package virtualzoo.ui;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import virtualzoo.core.*;

public class AdministratorFrame extends JFrame {
    
    public AdministratorFrame() {
        super("Zoo Administrator");
        
        // Set to native look & feel
        try {
            UIManager.setLookAndFeel
                                (UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            // If unable just carry on with default look & feel
        }
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new ExitListener());
        
        // Create toolbar
        add(new ZooToolBar(this), BorderLayout.NORTH);

        // Create tabbed pane
        JTabbedPane tabPane = new JTabbedPane();

        // Create animal panel
        AnimalPanel animalPanel = new AnimalPanel();
        tabPane.addTab("Animals", animalPanel);
        
        // Create zoo keeper panel
        ZooKeeperPanel zooKeeperPanel = new ZooKeeperPanel();
        tabPane.addTab("Zoo Keepers", zooKeeperPanel);
        
        // Create visitor table
        VisitorTable visitorTable = new VisitorTable();
        tabPane.addTab("Visitors", new JScrollPane(visitorTable));
        
        // Create drawing panel
        PenguinPicture penguinPicture = new PenguinPicture();
        tabPane.addTab("Penguin Picture", penguinPicture);
        
        // Create image panel
        PenguinImage penguinImage = new PenguinImage();
        tabPane.addTab("Penguin Image", penguinImage);
        
        add(tabPane, BorderLayout.CENTER);        

        // Set the menu bar
        setJMenuBar(new ZooMenuBar(this));

        // Set components to their preferred size
        pack();
        
        // Place in the centre of the desktop
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }
    
    void confirmClose() {
        // Prompt for confirmation
        int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?",
                "Exit Person Manager",
                JOptionPane.YES_NO_OPTION);

        // See what response is
        if (response == JOptionPane.YES_OPTION) {
            try {
                // End the application
                ZooAdministrator.save();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Unable to save data.",
                        JOptionPane.ERROR_MESSAGE);
            } finally {
                dispose();
            }
        }
    }    
    
    private class ExitListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            confirmClose();
        }

    }
}