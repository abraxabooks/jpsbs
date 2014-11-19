package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public class Booker extends Thread {
    
    private BookingCounter booking;
    
    Booker(BookingCounter booking) {
        this.booking = booking;
    }
    
    @Override
    public void run() {
        booking.makeBooking();
    }
    
}
