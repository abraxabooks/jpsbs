package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public class BookingCounter {
    
    private int count;
    
    BookingCounter() {
        count = 0;
    }
    
    public synchronized int getCount() {
        return count;
    }
    
    synchronized void makeBooking() {
        // Get copy of current count
        int copyCount = count;
        
        // Add one to the copy count
        copyCount++;
        
        // Sleep for 1 millisecond to allow another thread to run
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        // Update the actual count from the copy
        count = copyCount;
    }
    
}
