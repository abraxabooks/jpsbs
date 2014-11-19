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

public class Monkey extends Animal {

    Monkey(String myName, Gender myGender) {
        this(myName, myGender, 0);
    }

    Monkey(String myName, Gender myGender, int myAge) {
        super(myName, myGender, myAge);
    }
    
    @Override
    public String favouriteFood() {
            return "banana";
    }
    
    @Override
    public Animal.Type getType() {
        return Animal.Type.MONKEY;
    }
    
}
