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

public class ZooToolBar extends JToolBar {
    
    ZooToolBar(AdministratorFrame owner) {
        add(FeedingTimeAction.getInstance(owner));
    }
    
}