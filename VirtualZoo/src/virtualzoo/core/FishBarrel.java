package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public class FishBarrel {
    
    public static final int CAPACITY = 15;
    
    private int fishCount;
    
    FishBarrel() {
        fishCount = 0;
    }
    
    public synchronized int getCount() {
        return fishCount;
    }
    
    public synchronized boolean isEmpty() {
        return fishCount == 0;
    }
    
    public synchronized boolean isFull() {
        return fishCount == CAPACITY;
    }
        
    synchronized void addFish() {
        // Check whether barrel is already full
        while (isFull()) {
            // Barrel is full so wait
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        // If reached here barrel is not full so add a fish
        fishCount++;
        
        // Notify other waiting threads that state of barrel has changed
        notifyAll();
    }
        
    synchronized void takeFish() {
        // Check whether barrel is currently empty
        while (isEmpty()) {
            // Wait until barrel no longer empty
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        // If reached here barrel is not empty so remove a fish
        fishCount--;
        
        // Notify other waiting threads that state of barrel has changed
        notifyAll();
    }
    
}
