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
import javax.swing.*;

public class PenguinPicture extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.drawString("Percy", 105, 40);
        
        g.fillOval(105, 65, 30, 30); // head
        g.fillOval(95, 90, 50, 100); // body
        g.fillOval(85, 110, 20, 50); // right wing
        g.fillOval(135, 110, 20, 50); // left wing
        g.fillRect(95, 185, 20, 10); // right foot
        g.fillRect(125, 185, 20, 10); // left foot
        
        g.setColor(Color.WHITE);
        g.fillOval(111, 70, 8, 8); // right eye
        g.fillOval(121, 70, 8, 8); // left eye
        g.fillOval(105, 100, 30, 80); // belly
    }
    
}