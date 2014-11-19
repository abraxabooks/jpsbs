package virtualzoo.ui;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class FeedingTimeAction extends AbstractAction {
    
    private static FeedingTimeAction instance;
    
    public static FeedingTimeAction getInstance(AdministratorFrame owner) {
        if (instance == null) {
            instance = new FeedingTimeAction(owner);
        }
        return instance;
    }
    
    private AdministratorFrame owner;
    
    private FeedingTimeAction(AdministratorFrame owner) {
        this.owner = owner;

        // Set the action's name
        putValue(Action.NAME, "Feeding Time...");

        // Set the action's hover help (used by toolbar)
        putValue(Action.SHORT_DESCRIPTION, "Feed the animals");

        // Set the action's small icon (used by menu bar)
        URL iconUrlSmall = getClass().getResource
                ("/toolbarButtonGraphics/development/Bean16.gif");
        putValue(Action.SMALL_ICON, new ImageIcon(iconUrlSmall));

        // Set the action's large icon (used by toolbar)
        URL iconUrlLarge = getClass().getResource
                ("/toolbarButtonGraphics/development/Bean24.gif");
        putValue(Action.LARGE_ICON_KEY, new ImageIcon(iconUrlLarge));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog d = new FeedingTimeDialog(owner);
        d.setVisible(true);
    }
    
}