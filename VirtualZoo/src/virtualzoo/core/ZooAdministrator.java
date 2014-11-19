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
import java.math.*;
import java.util.*;
import com.example.util.*;
import virtualzoo.core.event.*;
import virtualzoo.db.*;

public class ZooAdministrator implements Serializable {

    private static ZooAdministrator instance;

    public static ZooAdministrator getInstance() {
        if (instance == null) {
            ZooSerialization zser = ZooSerialization.getInstance();
            try {
                instance = zser.restore();
            } catch (FileNotFoundException ex) {
                instance = new ZooAdministrator();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return instance;
    }
    
    public static void save() throws Exception {
        ZooSerialization zser = ZooSerialization.getInstance();
        zser.save(getInstance());
    }
    
    private Collection<ZooKeeper> zooKeepers;
    private Collection<Visitor> visitors;
    private Collection<Pen> pens;
    private Map<ZooKeeper, Collection<Pen>> responsibilities;
    private transient Collection<ZooKeeperListener> zooKeeperListeners;
    private transient Collection<AnimalListener> animalListeners;

    private ZooAdministrator() {
        zooKeepers = new HashSet<ZooKeeper>();
        pens = new TreeSet<Pen>();
        visitors = new TreeSet<Visitor>();
        createExampleVisitors();
        createExamplePens();
        responsibilities = new HashMap<ZooKeeper, Collection<Pen>>();
        zooKeeperListeners = new ArrayList<ZooKeeperListener>();
        animalListeners = new ArrayList<AnimalListener>();
    }

    public ZooKeeper createZooKeeper(String name, String address,
            String email, String salary) throws ValidationException {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(new Person(name, address),
                                                new Email(email),
                                                new BigDecimal(salary));
            zooKeepers.add(zooKeeper);
            fireZooKeeperCreated(zooKeeper);
            return zooKeeper;
        } catch (NumberFormatException ex) {
            throw new ValidationException(salary + " is not a valid amount.");
        } catch (IllegalArgumentException ex) {
            throw new ValidationException(ex.getMessage());
        }
    }

    public void changeZooKeeper(ZooKeeper zooKeeper, String name,
            String address, String email, String salary)
                                            throws ValidationException {
        try {
            zooKeeper.setPerson(new Person(name, address));
            zooKeeper.setEmail(new Email(email));
            zooKeeper.setSalary(new BigDecimal(salary));
            fireZooKeeperChanged(zooKeeper);
        } catch (NumberFormatException ex) {
            throw new ValidationException(salary + " is not a valid amount.");
        } catch (IllegalArgumentException ex) {
            throw new ValidationException(ex.getMessage());
        }
    }

    public void removeZooKeeper(ZooKeeper zooKeeper) {
        zooKeepers.remove(zooKeeper);
        fireZooKeeperRemoved(zooKeeper);
    }

    public Collection<ZooKeeper> getZooKeepers() {
        return Collections.unmodifiableCollection(zooKeepers);
    }

    public Animal createAnimal(Animal.Type animalType,
                               Pen pen,
                               String name,
                               Gender gender,
                               int age) throws ValidationException {
        try {
            Animal animal = Animal.create(animalType, name, gender, age);
            acquireAnimal(animal, pen);
            fireAnimalCreated(animal);
            return animal;
        } catch (IllegalArgumentException ex) {
            throw new ValidationException(ex.getMessage());
        }
    }
    public void changeAnimal(Animal animal,
                         Pen pen,
                         String name,
                         Gender gender,
                         int age) throws ValidationException {
        try {
            animal.setName(name);
            animal.setGender(gender);
            animal.setAge(age);
            if (! animal.getPen().equals(pen)) {
                relinquishAnimal(animal);
                acquireAnimal(animal, pen);
            }
            fireAnimalChanged(animal);
        } catch (IllegalArgumentException ex) {
            throw new ValidationException(ex.getMessage());
        }
    }
    
    public void removeAnimal(Animal animal) {
        relinquishAnimal(animal);
        fireAnimalRemoved(animal);
    }
 
    public Collection<Animal> getAnimals(Pen pen) {
        return Collections.unmodifiableCollection(pen.getAnimals());
    }
    
    public void sendEmail(Emailable emailable) {
        System.out.println("Sending email to " + emailable.getEmail());
    }
    
    public Collection<Pen> getPens() {
        return Collections.unmodifiableCollection(pens);
    }
    
    public Collection<Visitor> getVisitors() {
        return Collections.unmodifiableCollection(visitors);
    }

    public Collection<String> feedingTime() {
        // Collect all the animals
        Collection<Animal> animals = new HashSet<Animal>();
        for (Pen pen : pens) {
            animals.addAll(pen.getAnimals());
        }

        // Sort the animals
        Collection<Animal> sortedAnimals = new TreeSet<Animal>(new Animal.SortByAgeName());
        sortedAnimals.addAll(animals);

        // Feed them one at a time
        Collection<String> messages = new ArrayList<String>();
        for (Animal anAnimal : sortedAnimals) {
            messages.add(anAnimal.getName()
                    + " is eating a " + anAnimal.favouriteFood());
        }
        return messages;
    }

    public void showZooKeeperResponsibilities() {
        System.out.println("Zoo Keeper Responsibilites");
        System.out.println("==========================");

        // For each zoo keeper in turn...
        for (ZooKeeper aZooKeeper : responsibilities.keySet()) {
            System.out.println(aZooKeeper.getName() + " looks after:");

            // Get current zoo keeper's pens
            Collection<Pen> pens = responsibilities.get(aZooKeeper);

            // For each pen in turn...
            for (Pen aPen : pens) {

                // Get the animals in the current pen
                Collection<Animal> animals = aPen.getAnimals();

                // For each animal in turn...
                for (Animal anAnimal : animals) {
                    System.out.println("-> " + anAnimal);
                }
            }
        }
    }

    public void addZooKeeperListener(ZooKeeperListener listener) {
        zooKeeperListeners.add(listener);
    }

    public void removeZooKeeperListener(ZooKeeperListener listener) {
        zooKeeperListeners.remove(listener);
    }
    
    private void fireZooKeeperCreated(ZooKeeper zooKeeper) {
        ZooKeeperEvent event = new ZooKeeperEvent(zooKeeper);
        for (ZooKeeperListener listener : zooKeeperListeners) {
            listener.zooKeeperCreated(event);
        }
    }

    private void fireZooKeeperChanged(ZooKeeper zooKeeper) {
        ZooKeeperEvent event = new ZooKeeperEvent(zooKeeper);
        for (ZooKeeperListener listener : zooKeeperListeners) {
            listener.zooKeeperChanged(event);
        }
    }

    private void fireZooKeeperRemoved(ZooKeeper zooKeeper) {
        ZooKeeperEvent event = new ZooKeeperEvent(zooKeeper);
        for (ZooKeeperListener listener : zooKeeperListeners) {
            listener.zooKeeperRemoved(event);
        }
    }
    public void addAnimalListener(AnimalListener listener) {
        animalListeners.add(listener);
    }

    public void removeAnimalListener(AnimalListener listener) {
        animalListeners.remove(listener);
    }

    private void fireAnimalCreated(Animal animal) {
        AnimalEvent event = new AnimalEvent(animal);
        for (AnimalListener listener : animalListeners) {
            listener.animalCreated(event);
        }
    }

    private void fireAnimalChanged(Animal animal) {
        AnimalEvent event = new AnimalEvent(animal);
        for (AnimalListener listener : animalListeners) {
            listener.animalChanged(event);
        }
    }

    private void fireAnimalRemoved(Animal animal) {
        AnimalEvent event = new AnimalEvent(animal);
        for (AnimalListener listener : animalListeners) {
            listener.animalRemoved(event);
       }
    }

    private void createExampleVisitors() {
        visitors.add(new Visitor(new Person("Mary Roberts"),
                new Email("mary@example.com")));
        visitors.add(new Visitor(new Person("Peter Harris"),
                new Email("peter@example.com")));
        visitors.add(new Visitor(new Person("Richard York"),
                new Email("richard@example.com")));
        visitors.add(new Visitor(new Person("Tanya West"),
                new Email("tanya@example.com")));
    }

    private void createExamplePens() {
        Pen lionPen = new Pen("Lion Lane");
        acquireLions(lionPen);
        pens.add(lionPen);

        Pen monkeyPen = new Pen("Monkey Mews");
        acquireMonkeys(monkeyPen);
        pens.add(monkeyPen);

        Pen penguinPen = new Pen("Penguin Parade");
        acquirePenguins(penguinPen);
        pens.add(penguinPen);
    }

//    private void createExampleResponsibilities() {
//        responsibilities = new HashMap<ZooKeeper, Collection<Pen>>();
//        
//        // Alice
//        Collection<Pen> alicePens = new HashSet<Pen>();
//        alicePens.add(monkeyPen);
//        alicePens.add(penguinPen);
//        responsibilities.put(alice, alicePens);
//        
//        // Bob
//        Collection<Pen> bobPens = new HashSet<Pen>();
//        bobPens.add(lionPen);
//        bobPens.add(monkeyPen);
//        bobPens.add(penguinPen);
//        responsibilities.put(bob, bobPens);
//        
//        // Charles
//        Collection<Pen> charlesPens = new HashSet<Pen>();
//        charlesPens.add(penguinPen);
//        responsibilities.put(charles, charlesPens);
//    }
    private void acquireAnimal(Animal animal, Pen pen) {
        pen.add(animal);
        animal.setPen(pen);
    }

    private void relinquishAnimal(Animal animal) {
        Pen currentPen = animal.getPen();
        currentPen.remove(animal);
        animal.setPen(null);
    }

    private void acquireLions(Pen lionPen) {
        acquireAnimal(new Lion("Leo", Gender.MALE, 2), lionPen);
        acquireAnimal(new Lion("Mr Fuzz", Gender.MALE, 2), lionPen);
        acquireAnimal(new Lion("Bazooka", Gender.FEMALE, 5), lionPen);
    }

    private void acquireMonkeys(Pen monkeyPen) {
        acquireAnimal(new Monkey("Bonzo", Gender.MALE, 5), monkeyPen);
        acquireAnimal(new Monkey("Norti", Gender.FEMALE, 5), monkeyPen);
        acquireAnimal(new Monkey("Hairball", Gender.MALE, 4), monkeyPen);
    }

    private void acquirePenguins(Pen penguinPen) {
        acquireAnimal(new Penguin("Sammy", Gender.FEMALE, 1), penguinPen);
        acquireAnimal(new Penguin("Oswald", Gender.MALE, 2), penguinPen);
        acquireAnimal(new Penguin("Percy", Gender.MALE), penguinPen);
        acquireAnimal(new Penguin("Petra", Gender.FEMALE, 2), penguinPen);
    }
    
    private void readObject(ObjectInputStream ois) throws IOException,
                                            ClassNotFoundException {
        ois.defaultReadObject();
        zooKeeperListeners = new ArrayList<ZooKeeperListener>();
        animalListeners = new ArrayList<AnimalListener>();
    }
}
