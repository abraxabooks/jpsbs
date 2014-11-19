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
import java.io.*;
import java.util.*;

public abstract class Animal implements Comparable<Animal>, Serializable {
    
    // The allowed animal types
    public enum Type {LION, MONKEY, PENGUIN};
    
    // Static variables
    private static int combinedAge;
    
    // Static methods
    public static int getCombinedAge() {
        return combinedAge;
    }
    
    // Factory method to create an animal of a specified type
    static Animal create(Animal.Type type, String name, Gender gender, int age) {
        Animal animal = null;
        if (type.equals(Animal.Type.LION)) {
            animal = new Lion(name, gender, age);

        } else if (type.equals(Animal.Type.MONKEY)) {
            animal = new Monkey(name, gender, age);

        } else {
            animal = new Penguin(name, gender, age);
        }
        return animal;
    }
    
    // Declare instance variables to hold an animal's attributes
    private String name;        // the animal's name
    private Gender gender;      // the animal's gender ("m" or "f")
    private int age;            // the animal's age in years
    private Date dateAdmitted;  // date animal was admitted to the zoo
    private Pen pen;
    
    
    // Define constructor
    Animal(String name, Gender gender, int age) {
        validate(name, gender, age);
        
        this.name = name;
        this.gender = gender;
        this.age = age;
        dateAdmitted = new Date(); // today's date is assumed
        
        // Add the animal's age to the coombined age total
        combinedAge += this.age;
    }
    
    
    // Define instance methods
    
    // Return the animal's name
    public String getName() {
        return name;
    }
    
    // Change the animal's name
    void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setName(String name, String nickName) {
        setName(name + " (also known as " + nickName + ")");
    }
    
    // Return the animal's gender
    public Gender getGender() {
        return gender;
    }
    
    // Change the animal's gender
    void setGender(Gender gender) {
        validateGender(gender);
        this.gender = gender;
    }
    
    public boolean isMale() {
        return gender.equals(Gender.MALE);
    }
    
    public boolean isFemale() {
        return gender.equals(Gender.FEMALE);
    }
    
    // Return the animal's age
    public int getAge() {
        return age;
    }
    
    // Change the animal's age
    void setAge(int age) {
        validateAge(age);
        this.age = age;
    }
    
    // Return the date the animal was admitted to the zoo
    public Date getDateAdmitted() {
        // Return defensive copy
        return new Date(dateAdmitted.getTime());
    }
    
    public boolean isEndangered() {
        return false;
    }
    
    public Pen getPen() {
        return pen;
    }
    
    void setPen(Pen pen) {
        this.pen = pen;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +
                name + ", " + gender + ", aged " + age;
    }
    
    @Override
    public int compareTo(Animal otherAnimal) {
        // Sort alphabetically by name
        int result = getName().compareTo(otherAnimal.getName());
        if (result != 0) return result;
        
        // Names are the same, so sort by gender
        result = getGender().compareTo(otherAnimal.getGender());
        if (result != 0) return result;

        // Genders are the same, so sort by age
        result = getAge() - otherAnimal.getAge();
        if (result != 0) return result;
        
        // If reached here name, gender  and age are the same.
        // So that method is consistent with equals() will now sort on has code.
        return hashCode() - otherAnimal.hashCode();
    }

    // Return the animal's favourite food
    public abstract String favouriteFood();
    
    // Return the animal's type
    public abstract Animal.Type getType();
    
    private void validate(String name, Gender gender, int age) {
        validateName(name);
        validateGender(gender);
        validateAge(age);
    }
    
    protected void validateAge(int age) {
        // Ensure new age is between 0 and 50
        if ((age < 0) || (age > 50)) {
            throw new IllegalArgumentException("Age must be 0 - 50");
        }
    }
    
    protected void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must be specified");
        }
    }

    protected void validateGender(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender must be specified");
        }
    }

    // Inner class to sort by age then name
    public static class SortByAgeName implements Comparator<Animal> {
        
        @Override
        public int compare(Animal animal1, Animal animal2) {
            // Sort by age
            int result = animal1.getAge() - animal2.getAge();
            if (result != 0) return result;

            // Sort alphabetically by name
            result = animal1.getName().compareTo(animal2.getName());
            if (result != 0) return result;

            // If reached here age and name are the same.
            // So that method is consistent with equals() will now sort on has code.
            return animal1.hashCode() - animal2.hashCode();
        }
    }
    
}
