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

public class PenguinApplet extends JApplet {

    private PenguinPicture penguinPicture;

    @Override
    public void init() {
        penguinPicture = new PenguinPicture();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        penguinPicture.paint(g);
        
        g.setColor(Color.BLUE);
        g.drawString("An unconvincing penguin", 50, 220);
    }
    
}