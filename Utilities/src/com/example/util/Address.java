package com.example.util;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.beans.*;
import java.io.*;

public class Address implements Serializable {
    
    private PropertyChangeSupport changeSupport;
    private String street;
    private String city;
    
    public Address() {
        super();
        changeSupport = new PropertyChangeSupport(this);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        String oldValue = this.street;
        this.street = street;
        changeSupport.firePropertyChange("street", oldValue, street);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldValue = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldValue, city);
    }
    
    public void addPropertyChangeListener
            (PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener
            (PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }   
    
}