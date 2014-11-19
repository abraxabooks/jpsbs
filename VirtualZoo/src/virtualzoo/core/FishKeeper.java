package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public class FishKeeper implements Runnable {
    
    public static final int TOTAL_FISH = 35;
    
    private FishBarrel barrel;
    private int fishRemaining;
    
    FishKeeper(FishBarrel barrel) {
        this.barrel = barrel;
        fishRemaining = TOTAL_FISH;
    }
    
    public int getFishRemaining() {
        return fishRemaining;
    }
    
    @Override
    public void run() {
        while (fishRemaining > 0) {
            barrel.addFish();
            fishRemaining--;
        }
    }
    
}
