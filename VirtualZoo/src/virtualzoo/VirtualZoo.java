package virtualzoo;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.math.*;
import java.util.*;
import virtualzoo.core.*;
import virtualzoo.ui.*;

public class VirtualZoo {

    public static void main(String[] args) {
        AdministratorFrame frame = new AdministratorFrame();
        
        // Methods to be invoked on admin will go here...
        
        // Source for for individual chapters...
        //chapter1();
        //chapter2();
        //chapter3();
        //chapter4();
    }

    
    private static void chapter1() {
//        Animal bruno = new Animal("Bruno", "m", 4);
//        Animal cuddles = new Animal("Cuddles", "f", 2);
//        Animal someDog = new Animal("Fido", "m", 3);
//        Animal aGiraffe = new Animal("Gilly the Giraffe", "f", 7);
//        
//        // Output bruno's details
//        System.out.println("Name: " + bruno.getName());
//        System.out.println("Gender: " + bruno.getGender());
//        System.out.println("Age: " + bruno.getAge());
//        
//        // Get some other details
//        String x = cuddles.getGender(); // what is cuddles' gender?
//        int ga = aGiraffe.getAge(); // how old is Gilly the Giraffe?
    }
    
    private static void chapter2() {
        // Create an instance of VirtualZoo so able to call instance methods
        VirtualZoo vz = new VirtualZoo();
        
        // Method that returns a String
        String s = vz.sayHello();
        System.out.println(s);
        
        // Method that passes one argument and returns a String
        s = vz.sayHello("Fred");
        System.out.println(s);
        
        // Method that passes three arguments and returns a String
        s = vz.sayHello("Fred", "Bloggs", 50);
        System.out.println(s);
        
        // Method that passes to int arguments and returns an int
        int value = vz.sum(3, 6);
        System.out.println(value);
        
        // Method that outputs a word
        vz.outputWord("Java");
        
        // Creating an object
        Date rightNow = new Date(); // defaults to today's date
        System.out.println(rightNow);
        
        // Object references
        Date date1 = new Date();
        Date date2 = date1; // both date1 and date2 reference the same object
        
        Date date3 = new Date();
        Date date4 = date3; // both date3 and date4 reference the same object
        
        // Logical error - should be adding not subtracting
        int numberOfMen = 7;
        int numberOfWomen = 5;
        int total = numberOfMen - numberOfWomen; // should use + not -
        
        // Example String methods
        String word = "banana";
        String anotherWord = word.toUpperCase();
        System.out.println("word = " + word + ", anotherWord = " + anotherWord);
        word = word.toUpperCase(); // updates word
        System.out.println("word = " + word);
        
        String word1 = new String("apple"); // this is perfectly valid
        String word2 = "orange"; // this is the shortcut technique
        
        String name1 = "Bob";
        String name2 = "Bob"; // Java reuses the same object reference as name1
        
        String name3 = "Thelma";
        String name4 = "Thelma"; // name3 and name4 are separate objects
        
        // Using the integer primitive types
        byte v1 = 47;           // stored in 8 bits
        short v2= -12345;       // stored in 16 bits
        int v3 = 123;           // stored in 32 bits
        long v4 = 1234567890;   // stored in 64 bits
        
        // Using the char primitive type
        char letterA = 'A';     // the letter A
        char tab = '\t';        // the tab character
        char greekLetterPi = '\u03c0';
        
        // Using the floating-point primitive types
        float f = 123.45f;      // the 'f' is required for floats
        double d = 123.45;      // 'd' at end is optional so is omitted here
        
        // Using the boolean primitive type
        boolean raining = true;
        boolean sunny = false;
        
        // Java 7 enhancements
        // (uncomment the following line if using Java 7)
        //int million = 1_000_000;
    }
    
    public static void chapter3() {
//        Animal bruno = new Animal("Bruno", "m", 4);
//        
//        // Change Bruno's details
//        bruno.setName("Bruuuuuno");
//        bruno.setGender("f"); // she was a girl all along!
//        bruno.setAge(5); // and now a year older
//        
//        // Output bruno's details
//        System.out.println("Name: " + bruno.getName());
//        System.out.println("Gender: " + bruno.getGender());
//        System.out.println("Age: " + bruno.getAge());
        
        // Creata a new born animal using overloaded constructors
//        Animal aCat1 = new Animal("Tiddles", "f"); // age of zero assumed
//        Animal aCat2 = new Animal("Arthur", "m", 0); // age of zero specified
        
        // Using overloaded methods
//        bruno.setName("Bruno", "The Beast");
//        System.out.println("Name: " + bruno.getName());
        
        // Using the Lion subclass
//        Lion leo = new Lion("Leo", "m", 8);
//        System.out.println(leo.getName());
//        
//        Animal clarence = new Lion("Clarence", "m", 12);
//        System.out.println(clarence.getName());
//        
//        // Creating different animal types
////        Animal animal1 = new Animal("Fred", "m", 2);
//        Animal animal2 = new Lion("Leo", "m", 8);
//        Animal animal3 = new Penguin("Oswald", "m", 3);
//        Animal animal4 = new Monkey("Bonzo", "f", 5);
    }
    
    public static void chapter4() {
//        Animal leo = new Lion("Leo", "m", 4);
//        
//        // Output Leo's admission date
//        Date date = leo.getDateAdmitted();
//        System.out.println(date);
//        
//        // Change Leo's admission date!
//        date.setYear(150); // gets added to 1900 - see Date class API
//        date = leo.getDateAdmitted();
//        System.out.println(date);
//        
//        // Using toString()
//        System.out.println(leo.toString());

        // Demonstrate problem with floating-point arithmetic
        double valueA = 2.0;                                // statement 1
        double valueB = 1.1;				    // statement 2
        double difference = valueA - valueB;    	    // statement 3
        System.out.println("difference = " + difference);   // statement 4
        
        // Calculation with BigDecimal
        BigDecimal valueX = new BigDecimal("2.0");	    // statement 1
        BigDecimal valueY = new BigDecimal("1.1");          // statement 2
        BigDecimal result = valueX.subtract(valueY);        // statement 3
        System.out.println("Difference = " + result);       // statement 4
        
        // Using BigDecimal with setScale()
        BigDecimal valueZ = new BigDecimal("123.456");
        valueZ = valueZ.setScale(2, RoundingMode.HALF_UP);
        System.out.println("valueZ = " + valueZ);
        
        // Using ZooKeeper
//        ZooKeeper alice = new ZooKeeper("Alice Smith", "Some City",
//            "alice@example.com", new BigDecimal("20000"));
//        System.out.println(alice);
        
        // Using null
//        Animal clarence;                            // statement 1
//        clarence = new Lion("Clarence", "m", 9);    // statement 2
//        clarence = null;                            // statement 3
        
        // Using overloaded constructor
//        Visitor mary = new Visitor("Mary Roberts", "mary@example.com");
//        Animal marysFavouriteAnimal = mary.getSponsoredAnimal();
//        //int age = marysFavouriteAnimal.getAge();
        
        // Creare an administrator
        ZooAdministrator admin = ZooAdministrator.getInstance();
        
        // Create a zoo keeper
//        ZooKeeper alice = new ZooKeeper("Alice Smith", "Some City",
//            "alice@example.com", new BigDecimal("20000"));
//
//        // Get the administrator to send an email to Alice
//        admin.sendEmail(alice);
//        
//        // Create a visitor
//        Visitor mary = new Visitor("Mary Roberts", "mary@example.com");
        
        // Try to send Mary an email
//        admin.sendEmail(mary);
    }
    
    // Instance methods in chapter 2
    public String sayHello() {
        return "Hello";
    }

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public String sayHello(String firstName, String lastName, 
                                                        int age) {
        return "Hello " + firstName + " " + lastName +
                ", you are " + age + " years old.";
    }
    
    public int sum(int firstNumber, int secondNumber) {
        int total = firstNumber + secondNumber;
        return total;
    }
    
    public void outputWord(String word) {
        System.out.println("Today's word is " + word);
    }
    
    public int twiceProduct(int firstNumber, int secondNumber,
                                        int thirdNumber) {
        // Add the three argument values
        int sum = firstNumber + secondNumber + thirdNumber;
        System.out.println("sum = " + sum);
        
        // Double the sum just calculated
        int twiceSum = sum * 3; // * means multiply, and should be by 2 not 3
        System.out.println("twiceSum = " + twiceSum);

        return twiceSum;
    }
    
}
