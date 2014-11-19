package virtualzoo.db;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.io.*;
import virtualzoo.core.*;

public class ZooSerialization {
    
    public static final String ZOO_FILENAME = "zoo.ser";    
    
    private static ZooSerialization instance;
    
    public static ZooSerialization getInstance() {
        if (instance == null) {
            instance = new ZooSerialization();
        }
        return instance;
    }
    
    private ZooSerialization() {
    }
    
    public void save(ZooAdministrator admin) throws IOException {
        File f = new File(ZOO_FILENAME);				// 1
        FileOutputStream fos = new FileOutputStream(f);			// 2
        BufferedOutputStream bos = new BufferedOutputStream(fos);	// 3
        ObjectOutputStream oos = new ObjectOutputStream(bos);		// 4
        oos.writeObject(admin);						// 5
        oos.close();							// 6
        System.out.println("Data has beeen saved to " +			// 7
                           f.getAbsolutePath());
    }
    
    public ZooAdministrator restore() throws ClassNotFoundException,
                                             IOException {
        File f = new File(ZOO_FILENAME);
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        ZooAdministrator admin = (ZooAdministrator) ois.readObject();
        ois.close();
        System.out.println("Data has beeen loaded from " + 
                           f.getAbsolutePath());
        return admin;
    }
    
}