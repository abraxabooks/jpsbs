package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import com.example.util.Gender;

public class Lion extends Animal {

    Lion(String myName, Gender myGender) {
        this(myName, myGender, 0);
    }

    Lion(String myName, Gender myGender, int myAge) {
        super(myName, myGender, myAge);
    }
    
    @Override
    public boolean isEndangered() {
        return true;
    }    
    @Override
    public String favouriteFood() {
            return "meat";
    }
    
    @Override
    public Animal.Type getType() {
        return Animal.Type.LION;
    }
    
    @Override
    protected void validateAge(int age) {
        // Ensure new age is between 0 and 20
        if ((age < 0) || (age > 20)) {
            throw new IllegalArgumentException("Age must be 0 - 20");
        }
    }
    
}
