/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class EmailTest {
    
    private Email fredEmail;
    
    public EmailTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        fredEmail = new Email("fred@example.com");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmail method, of class Email.
     */
    @Test
    public void testGetEmail() {
        // Run the method being tested
        String result = fredEmail.getEmail();
        
        // Make the assertion
        assert result.equals("fred@example.com") : "email not correct";
    }

    /**
     * Test of getLocalPart method, of class Email.
     */
    @Test
    public void testGetLocalPart() {
        // Run the method being tested
        String result = fredEmail.getLocalPart();
        
        // Make the assertion
        assert result.equals("fred") : "email local-part not correct";
    }

    /**
     * Test of getDomainPart method, of class Email.
     */
    @Test
    public void testGetDomainPart() {
        String result = fredEmail.getDomainPart();
        assert result.equals("example.com") : "email domain-part not correct";
    }

    /**
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        String result = fredEmail.toString();
        assert result.equals("fred@example.com") : "email not correct";
    }

    /**
     * Test of equals method, of class Email.
     */
    @Test
    public void test1Equals() {
        Email otherEmail = new Email("fred@example.com");
        assert fredEmail.equals(otherEmail) : "equals() should be true";
    }

    @Test
    public void test2Equals() {
        Email otherEmail = new Email("barney@example.com");
        assert ! fredEmail.equals(otherEmail) : "equals() should be false";
    }

    /**
     * Test of hashCode method, of class Email.
     */
    @Test
    public void test1HashCode() {
        Email otherEmail = new Email("fred@example.com");
        assert fredEmail.hashCode() == otherEmail.hashCode()
                : "hash codes should be same";
    }

    @Test
    public void test2HashCode() {
        Email otherEmail = new Email("barney@example.com");
        assert fredEmail.hashCode() != otherEmail.hashCode()
                : "hash codes should be different";
    }

    /**
     * Test of compareTo method, of class Email.
     */
    @Test
    public void test1CompareTo() {
        Email otherEmail = new Email("fred@example.com");
        assert fredEmail.compareTo(otherEmail) == 0 :
                "compareTo() should be zero";
    }

    @Test
    public void test2CompareTo() {
        Email otherEmail = new Email("barney@example.com");
        assert fredEmail.compareTo(otherEmail) > 0 :
                "compareTo() should be positive";
    }

    @Test
    public void test3CompareTo() {
        Email otherEmail = new Email("zebedee@example.com");
        assert fredEmail.compareTo(otherEmail) < 0 :
                "compareTo() should be negative";
    }
    
    @Test
    public void test1aValidate() {
        try {
            // space at start
            Email otherEmail = new Email(" fred@example.com");
            assert false : "exception should be thrown, space in email";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test1bValidate() {
        try {
            // space at end
            Email otherEmail = new Email("fred@example.com ");
            assert false : "exception should be thrown, space in email";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test1cValidate() {
        try {
            // space at middle
            Email otherEmail = new Email("fred@ex ample.com");
            assert false : "exception should be thrown, space in email";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test2aValidate() {
        try {
            // no @ character
            Email otherEmail = new Email("fredexample.com");
            assert false : "exception should be thrown, no @ found";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test2bValidate() {
        try {
            // one @ character
            Email otherEmail = new Email("fred@example.com");
        } catch (IllegalArgumentException ex) {
            assert false : "exception should not be thrown and one @ found";
        }
    }
    
    @Test
    public void test2cValidate() {
        try {
            // two @ characters
            Email otherEmail = new Email("fred@example@.com");
            assert false : "exception should be thrown, two @s found";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test3Validate() {
        try {
            // empty local-part
            Email otherEmail = new Email("@example.com");
            assert false : "exception should be thrown, empty local-part";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test4aValidate() {
        try {
            // no dot in domain-part
            Email otherEmail = new Email("fred@examplecom");
            assert false : "exception should be thrown, no dot in domain-part";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test4bValidate() {
        try {
            // two dots in domain-part
            Email otherEmail = new Email("fred@example.co.m");
        } catch (IllegalArgumentException ex) {
            assert false : "exception should not be thrown, two dots in domain-part";
        }
    }
    
    @Test
    public void test5aValidate() {
        try {
            // empty first sub-part of domain-part
            Email otherEmail = new Email("fred@.com");
            assert false : "exception should be thrown, empty first sub-part of domain-part";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test5bValidate() {
        try {
            // empty second sub-part of domain-part
            Email otherEmail = new Email("fred@example");
            assert false : "exception should be thrown, empty second sub-part of domain-part";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }
    
    @Test
    public void test5cValidate() {
        try {
            // empty third sub-part of domain-part
            Email otherEmail = new Email("fred@example.com.");
            assert false : "exception should be thrown, third second sub-part of domain-part";
        } catch (IllegalArgumentException ex) {
            // test passed
        }
    }

    /**
     * Test of equals method, of class Email.
     */
    @Test
    public void testEquals() {
    }

    /**
     * Test of hashCode method, of class Email.
     */
    @Test
    public void testHashCode() {
    }

    /**
     * Test of compareTo method, of class Email.
     */
    @Test
    public void testCompareTo() {
    }

}
