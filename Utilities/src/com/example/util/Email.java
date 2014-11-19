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

/**
 * The <code>Email</code> class represents an immutable email address
 * in the format <code>local-part@domain-part</code>.
 */
public final class Email implements Comparable<Email>, Serializable {
    
    private String email;

    /**
     * Constructs an Email object with the specified email address.
     * @param email the full email address
     * @throws <code>IllegalArgumentException</code> if the argument is not a valid email.
     * @throws <code>NullPointerException</code> if the argument is <code>null</code>.
     */
    public Email(String email) {
        this.email = email;
        validate();
    }
    
    /**
     * Returns the full email address.
     * @return the email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Returns the local-part of the email address,
     * that is, the part before the @ character.
     * @return the email local-part
     */
    public String getLocalPart() {
        int atIndex = email.indexOf('@');
        return email.substring(0, atIndex);
    }
    
    /**
     * Returns the domain-part of the email address,
     * that is, the part after the @ character.
     * @return the email domain-part
     */
    public String getDomainPart() {
        int atIndex = email.indexOf('@');
        return email.substring(atIndex + 1);
    }
    
    /**
     * Returns the full email address.
     * @return the full email address
     */
    @Override
    public String toString() {
        return getEmail();
    }
    
    /**
     * Compares this email to the specified object.
     * Returns <code>true</code> if the argument is not <code>null</code>
     * and is an <code>Email</code> object with the same email address.
     * @param other the object to compare this <code>Email</code> against.
     * @return <code>true</code> if the given object represents
     * an <code>Email</code> with the same address, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Email)) return false;
        Email otherEmail = (Email) other;
        return email.equals(otherEmail.email);
    }
    
    /**
     * Returns the hash code for this <code>Email</code> object.
     * The returned hash code will be the hash code of the email address string.
     * @return a hash code for this object.
     */
    @Override
    public int hashCode() {
        return email.hashCode();
    }
    
    /**
     * Compares this <code>Email</code> to the argument,
     * alphabetically by the email address string.
     * @param otherEmail the <code>Email</code> to compare against.
     * @return the value zero if the email address strings are the same,
     * a value less than zero if this email is alphabetically
     * before the argument, and a value greater than zero if this email
     * is alphabetically after the argument.
     */
    @Override
    public int compareTo(Email otherEmail) {
        return email.compareTo(otherEmail.email);
    }
    
    /**
     * Validate that the email:
     * 1. Has no spaces;
     * 2. Has exactly one @ character;
     * 3. Local-part is not empty;
     * 4. Domain-part contains at least one dot;
     * 5. Domain-part sections are not empty.
     * @throws <code>IllegalArgumentException</code> if the argument is not a valid email.
     * @throws <code>NullPointerException</code> if the argument is <code>null</code>.
     */
    private void validate() {
        // Ensure there are no spaces
        if (email.indexOf(' ') >= 0) {
            throw new IllegalArgumentException
                    ("Email must not contain a space character");
        }
        
        // Ensure there is exactly one @ character
        int countAts = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') countAts++;
        }
        if (countAts != 1) {
            throw new IllegalArgumentException
                    ("Email must contain exactly one @ character");
        }
        
        // Ensure local-part is not empty
        if (getLocalPart().isEmpty()) {
            throw new IllegalArgumentException
                    ("Email local-part must contain at least one character");
        }
        
        // Ensure domain-part contains at least one dot
        int countDots = 0;
        for (char c : getDomainPart().toCharArray()) {
            if (c == '.') countDots++;
        }
        if (countDots < 1) {
            throw new IllegalArgumentException
                    ("Email domain-part must contain at least one dot");
        }
        
        // Ensure each part of domain-part is not empty
        int fromIndex = 0;
        for (int i = 0; i < countDots; i++) {
            int dotIndex = getDomainPart().indexOf('.', fromIndex);
            String part = getDomainPart().substring(fromIndex, dotIndex);
            if (part.isEmpty()) {
                throw new IllegalArgumentException
                        ("Email domain-part is not valid");
            }
            fromIndex = dotIndex + 1;
        }
        // check the part after the last dot
        String part = getDomainPart().substring(fromIndex);
        if (part.isEmpty()) {
            throw new IllegalArgumentException
                    ("Email domain-part is not valid");
        }
    }
    
}
