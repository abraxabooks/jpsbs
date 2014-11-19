package virtualzoo.ui;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import virtualzoo.core.*;
import virtualzoo.core.event.*;
import java.util.*;
import javax.swing.*;

public class ZooKeeperList extends JList implements ZooKeeperListener {

    private ZooKeeperListModel model;

    public ZooKeeperList() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = new ZooKeeperListModel();
        setModel(model);
    }

    @Override
    public void zooKeeperCreated(ZooKeeperEvent event) {
        model.loadModel();
        deselectListItems();
    }

    @Override
    public void zooKeeperChanged(ZooKeeperEvent event) {
        model.loadModel();
    }

    @Override
    public void zooKeeperRemoved(ZooKeeperEvent event) {
        model.loadModel();
        deselectListItems();
    }
    
    void deselectListItems() {
        removeSelectionInterval(0, model.getSize());
    }


    private class ZooKeeperListModel extends DefaultListModel {
        
        private ZooAdministrator admin;
        private List<ZooKeeper> zooKeepers;
        
        public ZooKeeperListModel() {
            admin = ZooAdministrator.getInstance();
            loadModel();
        }
        
        private void loadModel() {
            zooKeepers = 
                    new ArrayList<ZooKeeper>(admin.getZooKeepers());
            Collections.sort(zooKeepers);
            fireContentsChanged(this, 0, zooKeepers.size() - 1);
        }

        @Override
        public Object getElementAt(int index) {
            return zooKeepers.get(index);
        }

        @Override
        public int getSize() {
            return zooKeepers.size();
        }
    }
}