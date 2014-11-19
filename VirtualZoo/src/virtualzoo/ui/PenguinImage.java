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
import java.net.*;
import javax.swing.*;

public class PenguinImage extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        URL penguin = getClass().getResource("images/penguin.jpg");
        Image image = new ImageIcon(penguin).getImage();
        g.drawImage(image, 10, 20, this);
    }
    
}