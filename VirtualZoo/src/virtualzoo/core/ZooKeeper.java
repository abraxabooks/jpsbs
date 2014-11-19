package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.math.*;
import com.example.util.*;
import java.io.*;

public class ZooKeeper implements Emailable, Comparable<ZooKeeper>, Serializable {

    private Person person;
    private Email email;
    private BigDecimal salary;

    ZooKeeper(Person person, Email email, BigDecimal salary) {
        validate(person.getName(), person.getAddress(), email, salary);
        this.person = new Person(person); // uses copy constructor
        this.email = email;
        this.salary = salary;
    }

    public Person getPerson() {
        return new Person(person); // uses copy constructor
    }

    void setPerson(Person person) {
        validateName(person.getName());
        validateAddress(person.getAddress());
        this.person = new Person(person); // uses copy constructor
    }

    public String getName() {
        return person.getName();
    }

    public String getAddress() {
        return person.getAddress();
    }

    @Override
    public Email getEmail() {
        return email;
    }

    void setEmail(Email email) {
        validateEmail(email);
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    void setSalary(BigDecimal salary) {
        validateSalary(salary);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(ZooKeeper otherZooKeeper) {
        // Sort alphabetically by name
        int result = getName().compareTo(otherZooKeeper.getName());
        if (result != 0) {
            return result;
        }

        // Names are the same, so sort by email
        result = getEmail().compareTo(otherZooKeeper.getEmail());
        if (result != 0) {
            return result;
        }

        // If reached here name and email are the same.
        // So that method is consistent with equals() will now sort on has code.
        return hashCode() - otherZooKeeper.hashCode();
    }

    protected void validate(String name, String address,
                            Email email, BigDecimal salary) {
        validateName(name);
        validateAddress(address);
        validateEmail(email);
        validateSalary(salary);
    }

    protected void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must be specified");
        }
    }

    protected void validateAddress(String address) {
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address must be specified");
        }
    }

    protected void validateEmail(Email email) {
        if (email.toString().isEmpty()) {
            throw new IllegalArgumentException("Email must be specified");
        }
    }

    protected void validateSalary(BigDecimal salary) {
        if (salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salary must be specified");
        }
    }
}
