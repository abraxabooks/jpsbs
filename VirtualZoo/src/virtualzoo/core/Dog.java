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

public class Dog extends Animal {
    
    private int ageMultiplier;

    Dog(String myName, Gender myGender, int myAge,
            int ageMultiplier) {
        super(myName, myGender, myAge);
        this.ageMultiplier = ageMultiplier;
    }
    
    @Override
    public boolean isEndangered() {
        return true;
    }    
    @Override
    public String favouriteFood() {
            return "bone";
    }

    @Override
    void setAge(int age) {
        super.setAge(age);
        System.out.println("In human years = " + (age * ageMultiplier));
    }
        
    @Override
    public Animal.Type getType() {
        throw new UnsupportedOperationException();
    }

}
