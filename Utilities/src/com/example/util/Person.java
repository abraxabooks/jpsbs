package com.example.util;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.io.*;

public class Person implements Serializable {
    
    // Instance variables
    private String name;
    private String address;
    private Gender gender;
    
    // Constructors
    public Person(String name) {
        this(name, null);
    }
    
    public Person(String name, String address) {
        this(name, address, null);
    }
    
    public Person(String name, String address, Gender gender) {
        this.name = name;
        this.address = address;
        this.gender = gender;
    }
    
    // Copy constructor
    public Person(Person person) {
        this.name = person.getName();
        this.address = person.getAddress();
        this.gender = person.getGender();
    }
    
    // Instance methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public boolean isMale() {
        return gender.equals(Gender.MALE);
    }
    
    public boolean isFemale() {
        return gender.equals(Gender.FEMALE);
    }
    
    @Override
    public String toString() {
        return name + ", " + gender + ", " + address;
    }
}
