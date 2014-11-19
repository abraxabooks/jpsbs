package virtualzoo;

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
import java.net.*;
import java.util.*;
import virtualzoo.core.*;
import virtualzoo.ui.*;

public class Experiments {
    
    public static void main(String[] args) {
        // Experimental code will go here...
        
        //chapter5();
        //chapter6();
        //chapter7();
        //chapter9();
        //chapter10();
        //chapter11();
        //chapter12();
        //chapter13();
        //chapter19();
        //chapter20();
    }
    
    private static void chapter5() {
        // At this point no animals have been created
        System.out.println("Combined age = " + Animal.getCombinedAge());
        
        // Now create an animal aged 3
//        Animal leo = new Lion("Leo", Gender.MALE, 3);
//        leo.setGender(Gender.FEMALE);
//        System.out.println("Combined age = " + Animal.getCombinedAge());
        
        // Create another animal aged 4
//        Animal bonzo = new Monkey("Monkey", Gender.MALE, 4);
//        System.out.println("Combined age = " + Animal.getCombinedAge());
        
        // Using if for conditional statements
        int a = 3;
        int b = 4;

        if (a == b) {
            System.out.println("a is equal to b");
        }

        if (a != b) {
            System.out.println("a is not equal to b");
        }

        if (a < b) {
            System.out.println("a is less than b");
        }

        if (a <= b) {
            System.out.println("a is less than or equal to b");
        }

        if (a > b) {
            System.out.println("a is greater than b");
        }

        if (a >= b) {
            System.out.println("a is greater than or equal to b");
        }
        
        // Using if with booleans
        boolean sunny = true;
        boolean raining = false;

        if (sunny == true) {
            System.out.println("It is sunny");
        }

        if (sunny == false) {
            System.out.println("It is not sunny");
        }

        if (sunny != true) {
            System.out.println("It is not sunny");
        }

        if (sunny != false) {
            System.out.println("It is sunny");
        }

        if (sunny == raining) {
            System.out.println("It is either sunny and raining" +
                                 " or not sunny and not raining");
        }

        if (sunny != raining) {
            System.out.println("It is either sunny and not raining" +
                                 " or not sunny and is raining");
        }
        
        // if statement without braces
        if (sunny == true) System.out.println("It is sunny");
        
        // if statement with implied test for true
        if (sunny) {
            System.out.println("It is sunny");
        }
        
        // if statement with implied test for false
        if (! sunny) {
            System.out.println("It is not sunny");
        }
        // Compound operators
        int i = 3;
        int j = 4;
        double x = 8.4;
        double y = 9.7;

        // Logical and: both must be true
        if ((i < j) && (x > y)) {
            // the first comparison is true and the second is false
            // therefore the final result is false and this block of
            // code will not be entered.
            System.out.println("Should not be output");
        }

        // Logical or: either (or both) must be true
        if ((i < j) || (x > y)) {
            // the first comparison is true and the second is false
            // therefore the final result is true and this block of
            // code will be entered.
            System.out.println("Should be output");
        }
        
        // Using ! with compound comparisons
        //boolean sunny = true;     // defined earlier
        //boolean raining = false;  // defined earlier
        boolean cold = false;
        boolean windy = true;

        if (sunny && !raining && !cold && windy) {
            System.out.println("It is sunny, not raining, " +
                    "not cold and is windy");
        }
        
        // Using methods that return a boolean
        Experiments instance = new Experiments();
        instance.weatherCheck();
        String myClothes = instance.whatShouldIWear(23);
        System.out.println(myClothes);
        
        // Using ternary operator
        int temperature = 27;
        String weather = temperature > 25 ? "hot" : "not hot";
        System.out.println(weather);
        
        // Using switch block
        String day = instance.dayName(3);
        System.out.println(day);
        
        // Java 7 allows switch case statements to compare strings
//        switch (day) {
//            case "Monday":
//                // do something for Monday
//                break;
//            default:
//                // some other day
//        }
        
        // Casting primitives
        instance.castingPrimitives();
        instance.castingObjects();
        instance.arithmeticOperations();
    }
    
    // Instance variables for chapter 5
    private int temperature = 27;
    
    // Methods for chapter 5
    private boolean isHot() {
        return (temperature >= 25);
    }
    
    private void weatherCheck() {
        if (isHot()) {
            System.out.println("It is hot");
        } else {
            System.out.println("It is not hot");
        }
    }
    
    private String whatShouldIWear(int temperature) {
        String clothing;

        if (temperature < 2) {
            clothing = "winter coat";

        } else if (temperature < 10) {
            clothing = "wooly jumper";		

        } else if (temperature < 15) {
            clothing = "suit";		

        } else if (temperature < 21) {
            clothing = "t-shirt";		

        } else if (temperature < 27) {
            clothing = "shorts";		

        } else {
            clothing = "suncream";		
        }

        return clothing;
    }   
    
    private String dayName(int dayNumber) {
        String name;

        switch (dayNumber) {
            case 0:
                name = "Sunday";
                break;
            case 1:
                name = "Monday";
                break;
            case 2:
                name = "Tuesday";
                break;
            case 3:
                name = "Wednesday";
                break;
            case 4:
                name = "Thursday";
                break;
            case 5:
                name = "Friday";
                break;
            case 6:
                name = "Saturday";
                break;
            default:
                name = "* unknown *";
        }

        return name;
    }
    
    private void castingPrimitives() {
        byte b = 4;
        int i = b; // allowed because int is bigger than byte
        
        int i2 = 4;
        //byte b = j; // THIS WILL NOT COMPILE
        byte b2 = (byte) i2; // this cast will allow compilation
        
        double d = 2.8;
        int i3 = (int) d; // i3 will contain the value 2
    }
    
    private void castingObjects() {
        // Implicit casting - Lion implicitly cast to Animal
//        Animal leo = new Lion("Leo", Gender.MALE, 3);
        
        //Lion leo2 = leo; // WON'T COMPILE
//        Lion leo2 = (Lion) leo; // explicit casting to Lion
    }
    
    private void arithmeticOperations() {
        // Division
        double d = 3.0 / 4.0;	// d becomes 0.75
        int i = 3 / 4;		// i becomes 0 (int has no decimals)
        int j = 15 / 2; 	// j becomes 7
        System.out.println("d=" + d + ", i=" + i + ", j=" + j);

        // if either value is floating point, the result will be as well
        double e = 15 / 2.0;	// e becomes 7.5
        System.out.println("e=" + e);

        // here both operands are int so that is computed first
        double f = 15 / 2;		// f becomes 7.0
        System.out.println("f=" + f);

        // modulus (remainder after division)
        int k = 34 % 5;		// k becomes 4
        double g = 3.5 % 2.1;	// f becomes 1.4
        System.out.println("k=" + k + ", g=" + g);

        // negation
        int a = 2;
        int b = -a;		// b becomes -2 (- is prefix op rather than subtraction here)
        System.out.println("a=" + a + ", b=" + b);

        // precedence rules – use brackets to avoid ambiguity
        int p = 3 + (4 * 5);	// p becomes 23
        int q = (3 + 4) * 5;	// q becomes 35
        System.out.println("p=" + p + ", q=" + q);

        // increment & decrement (++, --)
        int r = 10;
        int s = r++;		// r becomes 11, but s becomes 10...!!!
        System.out.println("r=" + r + ", s=" + s);

        r = 10;
        s = ++r;           // now both r and s will be 11
        System.out.println("r=" + r + ", s=" + s);
    }
    
    private static void chapter6() {
        // Define array of temperatures for 12 months
        int[] monthlyTemperatures = new int[12];
        
        // The following values will each be zero at this stage
        int january     = monthlyTemperatures[0];
        int february    = monthlyTemperatures[1];
        int march       = monthlyTemperatures[2];
        int april       = monthlyTemperatures[3];
        int may         = monthlyTemperatures[4];
        int june        = monthlyTemperatures[5];
        int july        = monthlyTemperatures[6];
        int august      = monthlyTemperatures[7];
        int september   = monthlyTemperatures[8];
        int october     = monthlyTemperatures[9];
        int november    = monthlyTemperatures[10];
        int december    = monthlyTemperatures[11];
        
        // Set temperature for March
        monthlyTemperatures[2] = 8; // index 2 is third element in array
        
        // Define array of four Animal objects
        Animal[] animals = new Animal[4];
        
        // The following references will be null at this stage
        Animal firstAnimal  = animals[0];
        Animal secondAnimal = animals[1];
        Animal thirdAnimal  = animals[2];
        Animal fourthAnimal = animals[3];
        
        // Create objects for each element in animals array
//        animals[0] = new Lion("Leo", Gender.MALE, 3);
//        animals[1] = new Monkey("Bonzo", Gender.MALE, 2);
//        animals[2] = new Penguin("Petra", Gender.FEMALE, 1);
//        animals[3] = new Penguin("Oswald", Gender.MALE, 4);
        
        // Get name of first animal in the array
        String name = animals[0].getName();
        System.out.println("Name of first animal is " + name);
        
        // Using short-cut technique to declare and assign
        int[] numbers = {14, 896, -28};
        String[] sentence = {"words", "in", "a", "sentence"};
//        Animal[] pets = {new Lion("Leo", Gender.MALE, 3),
//                         new Penguin("Percy", Gender.MALE, 2)};
        
        // 2-dimensional arrays
        
        // 10 rows, 5 columns
        int[][] tabularData = new int[10][5];
        
        // Set value for third row, fifth column
        tabularData[2][4] = 123; // remember, indexes start from 0
        
        // Using the Pen class
//        Pen penguinPen = new Pen("Penguin Parade");
//        penguinPen.add(new Penguin("Petra", Gender.FEMALE, 1));
//        penguinPen.add(new Penguin("Oswald", Gender.MALE, 2));
        
//        System.out.println("The pen is called " + penguinPen.getName());
//        System.out.println("There are " + penguinPen.getCount() +
//                " animals in the pen");
        
        // Get the animals in the pen
//        Animal[] animalsInPen = penguinPen.getAnimals();
//        
//        // Standard for loop
//        for (int i = 0; i < animalsInPen.length; i++) {
//            System.out.println(animalsInPen[i]);
//        }
//        
//        // for-each loop
//        for (Animal anAnimal : animalsInPen) {
//            System.out.println(anAnimal);
//        }
//        
//        // while loop
//        int index = 0;
//        while (index < penguinPen.getCount()) {
//            System.out.println(animalsInPen[index]);
//            index++;
//        }
//        
//        // do-while loop
//        index = 0;
//        do {
//            System.out.println(animalsInPen[index]);
//            index++;
//        } while (index < penguinPen.getCount());

        // Array of values
        int[] values = new int[5];
        values[0] = 17;
        values[1] = 12;
        values[2] = 24;
        values[3] = 97;
        values[4] = 3;
        
        // Sort into numerical order
        Arrays.sort(values);
        for (int v : values) {
            System.out.println(v);
        }
        
        // Sorting animals in the pen
//        Arrays.sort(animalsInPen); // sort using natural ordering
//        for (Animal anAnimal : animalsInPen) {
//            System.out.println(anAnimal);
//        }
//
//        Arrays.sort(animalsInPen, new Animal.SortByAgeName()); // sort using alternate ordering
//        for (Animal anAnimal : animalsInPen) {
//            System.out.println(anAnimal);
//        }
    }
    
    private static void chapter7() {
        // Unchecked exceptions
        int numerator = 123;
        int denominator = 0;
        if (denominator != 0) {
            System.out.println("answer = " + (numerator / denominator));
        } else {
            System.out.println("denominator is zero");
        }

        ZooKeeper fred = null;
        if (fred != null) {
            // NullPointerException has been avoided
            String fredName = fred.getName();
        }

        // Checked exceptions
        FileReader someFile = null;
        try {
            someFile = new FileReader("filename.txt");
            int c = someFile.read();
        //} catch (FileNotFoundException ex) {
        //    System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (someFile != null) {
                try {
                    someFile.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        // Java 7 use of exceptions
//        try (FileReader someFile2 = new FileReader("filename.txt")) {
//            int c = someFile2.read();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
        
        // Calling setAge() on Animal with silly value
//        Animal leo = new Lion("Leo", Gender.MALE, 3);
        //leo.setAge(-12);
        
        // Using Dog
//        Animal fido = new Dog("Fido", Gender.MALE, 2, 7);
//        System.out.println(fido.getAge());
    }
    
    private static void chapter9() {
        // Using == on primitives
        int a = 3;
        int b = 3;
        int c = 4;
        
        boolean x = a == b;
        boolean y = a == c;
                
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        
        // Using == on object references
        Integer integerA = new Integer(3);
        Integer integerB = new Integer(3);
        Integer integerC = new Integer(4);
        
        x = integerA == integerB;
        y = integerA == integerC;
                
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        
        // Using equals() method with Integer
        x = integerA.equals(integerB);
        y = integerA.equals(integerC);
                
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        
        // Using equals() method with Email
        Email emailA = new Email("fred@example.com");
        Email emailB = new Email("fred@example.com");
        Email emailC = new Email("barney@example.com");

        x = emailA.equals(emailB);
        y = emailA.equals(emailC);
                
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        
        // Using equals() method with String
        String stringA = "abc";
        String stringB = "abc";
        String stringC = "def";

        x = stringA.equals(stringB);
        y = stringA.equals(stringC);
                
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        
        // Person class 
        Person p1 = new Person("Fred", "London", Gender.MALE);
        Person p2 = new Person("Fred", "London", Gender.MALE);
        System.out.println("p1.equals(p2) = " + p1.equals(p2));
    }
    
    private static void chapter10() {
        Email e = new Email("fred@example@.com");
        System.out.println(e);
    }
    
    private static void chapter11() {
        // Create an empty list of words
        //Collection<String> words = new ArrayList<String>();
        //List<String> words = new ArrayList<String>();
        
        // Create empty set of words
        //Collection<String> words = new HashSet<String>();
        Collection<String> words = new TreeSet<String>();
        
        // Add some words to the list
        words.add("To");
        words.add("be");
        words.add("or");
        words.add("not");
        words.add("to");
        words.add("be");
        words.add("that");
        words.add("is");
        words.add("the");
        words.add("question");
        
        // Output the words
        for (String s : words) {
            System.out.println(s);
        }
        
        System.out.println("The list contains " + words.size() + " words");
        
        // Get individual words
        //String firstWord = words.get(0);
        //String secondWord = words.get(1);
        //String lastWord = words.get(words.size() - 1);
        
        // Feeding time
        ZooAdministrator admin = ZooAdministrator.getInstance();
        admin.feedingTime();
        
        // Create a Map: key is English word, value is French word
        //Map<String, String> dictionary = new HashMap<String, String>();
        Map<String, String> dictionary = new TreeMap<String, String>();
        
        //Map<String, String> sortedDictionary = new TreeMap<String, String>(dictionary);
        //Collection<String> frenchWords = new TreeSet<String>(dictionary.values());
        
        // Add some words to the dictionary
        dictionary.put("yes", "oui");
        dictionary.put("no", "non");
        dictionary.put("hello", "bonjour");
        dictionary.put("goodbye", "au revoir");
        
        // What is the French for hello?
        System.out.println("The French for hello is " + dictionary.get("hello"));
        
        // Output the dictionary
        for (String englishWord : dictionary.keySet()) {
            String frenchWord = dictionary.get(englishWord);
            System.out.println("The English word " + englishWord +
                    " is " + frenchWord + " in French");
        }
        
        // Output the dictionary values
        for (String frenchWord : dictionary.values()) {
            System.out.println(frenchWord);
        }
        
        // Map for a lottery
        Map<String, Collection<Integer>> lotterySyndicate =
                new HashMap<String, Collection<Integer>>();
        
        // John's lottery numbers
        Collection<Integer> numbersForJohn = new TreeSet<Integer>();
        numbersForJohn.add(4);
        numbersForJohn.add(16);
        numbersForJohn.add(23);
        numbersForJohn.add(29);
        numbersForJohn.add(36);
        numbersForJohn.add(42);
        lotterySyndicate.put("John", numbersForJohn);
        
        // Sue's lottery numbers
        Collection<Integer> numbersForSue = new TreeSet<Integer>();
        numbersForSue.add(9);
        numbersForSue.add(11);
        numbersForSue.add(29);
        numbersForSue.add(25);
        numbersForSue.add(36);
        numbersForSue.add(37);
        lotterySyndicate.put("Sue", numbersForSue);
        
        // Output the lottery numbers
        System.out.println(lotterySyndicate);
        
        // Run showZooKeeperResponsibilities()
        admin.showZooKeeperResponsibilities();
        
        // Java 7
        //Map<String, String> dictionary2 = new HashMap();
    }
    
    private static void chapter12() {
//        // Create a single BookingCounter
//        BookingCounter booking = new BookingCounter();
//        
//        // Create 100 Booker threads using the same BookingCounter
//        for (int i = 0; i < 100; i++) {
//            Booker b = new Booker(booking);
//            b.start();
//        }
//        
//        // Allow time for all threads to complete
//        try {
//            Thread.sleep(1000); // 1000 milliseconds = 1 second
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println("Number of bookings made: " + booking.getCount());
//        
//        // Create a Person and an Email
//        Person p = new Person("Fred");
//        Email e = new Email("fred@example.com");
//        
//        // Create 100 VisitorBooker threads using same BookingCounter
//        for (int i = 0; i < 100; i++) {
//            VisitorBooker vb = new VisitorBooker(p, e, booking);
//            Thread t = new Thread(vb);
//            t.start();
//        }
//        
//        // Allow time for all threads to complete
//        try {
//            Thread.sleep(1000); // 1000 milliseconds = 1 second
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println("Number of bookings made: " + booking.getCount());
//        
//        // Using wait() and notifyAll()
//        // ============================
//        
//        // Create a single FishBarrel
//        FishBarrel barrel = new FishBarrel();
//        
//        // Create a single threaded FishKeeper
//        FishKeeper keeper = new FishKeeper(barrel);
//        
//        // Create three threaded HungryPenguin objects
//        HungryPenguin penguin1 = new HungryPenguin("penguin1", barrel);
//        HungryPenguin penguin2 = new HungryPenguin("penguin2", barrel);
//        HungryPenguin penguin3 = new HungryPenguin("penguin3", barrel);
//        
//        // Start all the threads
//        new Thread(keeper).start();
//        new Thread(penguin1).start();
//        new Thread(penguin2).start();
//        new Thread(penguin3).start();
//        
//        // Allow time for all threads to complete
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println("penguin 1 eaten: " + penguin1.getEatenCount());
//        System.out.println("penguin 2 eaten: " + penguin2.getEatenCount());
//        System.out.println("penguin 3 eaten: " + penguin3.getEatenCount());
//        System.out.println("keeper has left: " + keeper.getFishRemaining());
//        System.out.println("fish left in barrel: " + barrel.getCount());
    }
    
    private static void chapter13() {
        ExampleFrame frame = new ExampleFrame();
        frame.setVisible(true);
    }
    
    private static void chapter19() {
        // Using DataOutputStream
        File myStream = new File("mystream.dat");
        DataOutputStream myDataOutputStream = null;
        try {
            myDataOutputStream = new DataOutputStream
                                     (new BufferedOutputStream
                                          (new FileOutputStream(myStream)));
            myDataOutputStream.writeInt(50);
            myDataOutputStream.writeBoolean(true);
            myDataOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                myDataOutputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        // Using DataInputStream
        File myStream2 = new File("mystream.dat");
        DataInputStream myDataInputStream = null;
        try {
            myDataInputStream = new DataInputStream
                                    (new BufferedInputStream
                                         (new FileInputStream(myStream2)));
            int i = myDataInputStream.readInt();
            boolean b = myDataInputStream.readBoolean();
            System.out.println("i=" + i + ", b=" + b);
        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        } finally {
            try {
                myDataInputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
        
        // Using FileWriter
        File myFile = new File("myfile.txt");
        BufferedWriter myBufferedWriter = null;
        try {
            myBufferedWriter = new BufferedWriter(new FileWriter(myFile));
            myBufferedWriter.write("To be, or not to be.");
            myBufferedWriter.newLine();
            myBufferedWriter.write("That is the question.");
            myBufferedWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                myBufferedWriter.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        // Using FileReader
        File myFile2 = new File("myfile.txt");
        BufferedReader myBufferedReader = null;
        String line = null;
        try {
            myBufferedReader = new BufferedReader(new FileReader(myFile2));
            line = myBufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = myBufferedReader.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                myBufferedReader.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    private static void chapter20() {
        // Using Socket
        try {
            Socket socket = new Socket("catalog.example.com", 4321);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
        // Using ServerSocket
        try {
            ServerSocket serverSocket = new ServerSocket(80); // port 80 = http
            Socket clientSocket = serverSocket.accept();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
