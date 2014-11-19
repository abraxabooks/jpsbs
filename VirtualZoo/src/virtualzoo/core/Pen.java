package virtualzoo.core;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.io.*;
import java.util.*;

public class Pen implements Comparable<Pen>, Serializable {
    
    private String name;
    private Collection<Animal> animals;
    
    Pen(String name) {
        this.name = name;
        animals = new HashSet<Animal>();
    }
    
    void add(Animal animal) {
        animals.add(animal);
    }
    
    void remove(Animal animal) {
        animals.remove(animal);
    }
    
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(animals);
    }
    
    public int getCount() {
        return animals.size();
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Pen otherPen) {
        // Sort alphabetically by name
        int result = getName().compareTo(otherPen.getName());
        if (result != 0) return result;
        
        /*
         * If reached here names are the same.
         * So that method is consistent with equals() will now
         * sort on hash code.
         */
        return hashCode() - otherPen.hashCode();
    }
    
}
