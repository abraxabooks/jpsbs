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
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class VisitorTable extends JTable {
    
    private TableModel model;
    
    VisitorTable() {
        model = new VisitorTableModel();
        setModel(model);
    }
    
    
    private class VisitorTableModel extends AbstractTableModel {
        
        private List<Visitor> visitors;
        
        public VisitorTableModel() {
            ZooAdministrator admin = ZooAdministrator.getInstance();
            visitors = new ArrayList<Visitor>(admin.getVisitors());
        }

        @Override
        public int getRowCount() {
            return visitors.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    // First column - vistor's name
                    return visitors.get(rowIndex).getName();
                case 1:
                    // Second column - visitor's email
                    return visitors.get(rowIndex).getEmail().toString();
                case 2:
                    // Third column - visitors sponsored animal
                    Animal sponsoredAnimal = 
                            visitors.get(rowIndex).getSponsoredAnimal();
                    if (sponsoredAnimal != null) {
                        return sponsoredAnimal;
                    } else {
                        return "";
                    }
                default:
                    // Should not happen
                    throw new IllegalStateException();
            }
        }

        @Override
        public String getColumnName(int columnIndex) {
            String[] columnHeaders = 
                    {"Name", "Email Address", "Sponsored Animal"};
            return columnHeaders[columnIndex];
        }
    
    }
    
}
