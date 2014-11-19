package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import com.example.util.*;
import java.io.*;

public class Visitor implements Emailable, Comparable<Visitor>, Serializable {
    
    private Person person;
    private Email email;
    private Animal sponsoredAnimal;

    // Craete a Visitor object withouty a sponsored animal
    Visitor(Person person, Email email) {
        this(person, email, null);
    }
    
    Visitor(Person person, Email email, Animal sponsoredAnimal) {
        this.person = new Person(person); // uses copy constructor
        this.email = email;
        this.sponsoredAnimal = sponsoredAnimal;
    }
    
    public Person getPerson() {
        return new Person(person); // uses copy constructor
    }
    
    void setPerson(Person person) {
        this.person = new Person(person); // uses copy constructor
    }

    public String getName() {
        return person.getName();
    }

    @Override
    public Email getEmail() {
        return email;
    }

    void setEmail(Email email) {
        this.email = email;
    }

    public Animal getSponsoredAnimal() {
        return sponsoredAnimal;
    }

    void setSponsoredAnimal(Animal sponsoredAnimal) {
        this.sponsoredAnimal = sponsoredAnimal;
    }
 
    @Override
    public int compareTo(Visitor otherVisitor) {
        // Sort alphabetically by name
        int result = getName().compareTo(otherVisitor.getName());
        if (result != 0) {
            return result;
        }

        // Names are the same, so sort by email
        result = getEmail().compareTo(otherVisitor.getEmail());
        if (result != 0) {
            return result;
        }

        // If reached here name and email are the same.
        // So that method is consistent with equals() will now sort on has code.
        return hashCode() - otherVisitor.hashCode();
    }
   
}
