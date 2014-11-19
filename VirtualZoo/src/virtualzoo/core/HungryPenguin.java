package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public class HungryPenguin implements Runnable {
    
    public static final int FISH_LIMIT = 10;
    
    private String name;
    private FishBarrel barrel;
    private int fishEaten;
    
    HungryPenguin(String name, FishBarrel barrel) {
        this.name = name;
        this.barrel = barrel;
        fishEaten = 0;
    }
    
    public int getEatenCount() {
        return fishEaten;
    }
    
    @Override
    public void run() {
        while (fishEaten < FISH_LIMIT) {
            barrel.takeFish();
            fishEaten++;
            System.out.println(name + " has eaten fish " + fishEaten);
        }
    }
    
}
