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
import java.awt.event.*;

public class ZooMenuBar extends JMenuBar {
    
    private AdministratorFrame owner;
    private JMenu fileMenu, helpMenu;
    private JMenuItem fileFeedingTime, fileExit;
    private JMenuItem helpAbout;
    
    ZooMenuBar(AdministratorFrame owner) {
        this.owner = owner;
        
        buildFileMenu();
        add(fileMenu);

        buildHelpMenu();
        add(helpMenu);
    }
    
    private void buildFileMenu() {
        fileMenu = new JMenu("File");
        
        fileFeedingTime = 
                    new JMenuItem(FeedingTimeAction.getInstance(owner));
        fileMenu.add(fileFeedingTime);
        
        fileMenu.addSeparator();
        
        fileExit = new JMenuItem("Exit...");
        fileExit.addActionListener(new FileExitListener());
        fileMenu.add(fileExit);
    }
    
    private void buildHelpMenu() {
        helpMenu = new JMenu("Help");
        
        helpAbout = new JMenuItem("About Virtual Zoo...");
        helpAbout.addActionListener(new HelpAboutListener());
        helpMenu.add(helpAbout);
    }
    
    private class FileExitListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            owner.confirmClose();
        }
    }
    
    private class HelpAboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog
                            (owner,
                            "Sample application for the book " +
                            "Java Programming Step-by-Step.",
                             "About Virtual Zoo", 
                            JOptionPane.INFORMATION_MESSAGE);
        }

    }

}