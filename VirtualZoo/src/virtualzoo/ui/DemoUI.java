package virtualzoo.ui;

/*
 *  Java Programming Step-by-Step
 *  Copyright 2012, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;

public class DemoUI extends JFrame {
    
    public static void main(String[] args) {
        new DemoUI().setVisible(true);
    }
    
    public DemoUI() {
        super("Demonstrate UI Components");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        add(buildUI(), BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private JPanel buildUI() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Components will go here...
        //panel.add(buildJLabel());
        //panel.add(buildJTextField());
        //panel.add(buildJTextArea());
        //panel.add(buildJButton());
        //panel.add(buildJCheckBox());
        //panel.add(buildJRadioButton());
        //panel.add(buildJComboBox());
        //panel.add(buildJSlider());
        //panel.add(buildJSpinner1());
        //panel.add(buildJSpinner2());
        //panel.add(buildJSpinner3());
        //panel.add(buildJList1());
        panel.add(buildJTable());
        //panel.add(buildJTree());
        //panel.add(buildJSplitPane());
        //panel.add(buildJTabbedPane());
        //panel.add(buildJDialog());
        //panel.add(buildJOptionPane1());
        //panel.add(buildJOptionPane2());
        //panel.add(buildJOptionPane3());
        
        // Return the built panel
        return panel;
    }
    
    private JPanel buildJLabel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("This is a text label", JLabel.RIGHT);
        label.setText("Some different text");
        Font f = new Font("Serif", Font.BOLD, 22);
        label.setFont(f);
        
        // Using a colour constant: available constants are
        // BLACK, BLUE, CYAN, DARK_GREY, GRAY, GREEN, LIGHT_GRAY
        // MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW
        label.setForeground(Color.RED);
        
        // Using a red, green, blue combination
        label.setForeground(new Color(100, 50, 210));
        
        panel.add(label);
        return panel;
    }
    
    private JPanel buildJTextField() {
        JPanel panel = new JPanel(new BorderLayout());
        
        //JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel namePanel = new JPanel(new GridLayout(2, 1));

        namePanel.add(new JLabel("Enter your name:"));
        JTextField field = new JTextField("Default text", 25);
        namePanel.add(field);

        panel.add(namePanel);
        return panel;
    }
    
    private JPanel buildJTextArea() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea area = new JTextArea("Default text", 4, 30);
        
        panel.add(new JScrollPane(area));
        return panel;
    }
    
    private JPanel buildJButton() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JButton button = new JButton("Please click me");
        
        panel.add(new JScrollPane(button));
        return panel;
    }
    
    private JPanel buildJCheckBox() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JCheckBox wantFries = new JCheckBox("Do you want fries with that?");
        wantFries.setSelected(true);
        boolean b = wantFries.isSelected();
        
        panel.add(new JScrollPane(wantFries));
        return panel;
    }
    
    private JPanel buildJRadioButton() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Define the options
        JRadioButton redOption = new JRadioButton("Red");
        JRadioButton greenOption = new JRadioButton("Green");
        JRadioButton blueOption = new JRadioButton("Blue");

        // Assign the options to a group
        ButtonGroup group = new ButtonGroup();
        group.add(redOption);
        group.add(greenOption);
        group.add(blueOption);
        
        blueOption.setSelected(true);
        boolean b = redOption.isSelected();

        // Show the options in a grid
        JPanel colourPanel = new JPanel(new GridLayout(0, 1));
        colourPanel.add(redOption);
        colourPanel.add(greenOption);
        colourPanel.add(blueOption);

        // Add the grid to the main panel
        panel.add(colourPanel);
        return panel;
    }
    
    private JPanel buildJComboBox() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JComboBox colourCombo = new JComboBox();
        colourCombo.addItem("Red");
        colourCombo.addItem("Green");
        colourCombo.addItem("Blue");
        
        String selectedColour = (String) colourCombo.getSelectedItem();
        int selectedIndex = colourCombo.getSelectedIndex();

        panel.add(colourCombo);
        return panel;
    }
    
    private JPanel buildJSlider() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JSlider slider = new JSlider(0, 250, 50);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setOrientation(JSlider.VERTICAL);
        
        int value = slider.getValue();

        panel.add(slider);
        return panel;
    }
    
    private JPanel buildJSpinner1() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JSpinner spinner = new JSpinner();

        spinner.setValue(123);
        int v = (Integer) spinner.getValue();
        
        panel.add(spinner);        
        return panel;
    }
    
    private JPanel buildJSpinner2() {
        JPanel panel = new JPanel(new BorderLayout());
        
        ColourSpinnerModel model = new ColourSpinnerModel();
        JSpinner spinner = new JSpinner(model);

        String s = (String) spinner.getValue();
        
        panel.add(spinner);        
        return panel;
    }
    
    private JPanel buildJSpinner3() {
        JPanel panel = new JPanel(new BorderLayout());
        
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 10);
        JSpinner spinner = new JSpinner(model);

        int v = (Integer) spinner.getValue();
        
        panel.add(spinner);        
        return panel;
    }
    
    private JPanel buildJList1() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] options = {"Red", "Green", "Blue"};
        JList list = new JList(options);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(new JScrollPane(list));
        return panel;
    }
    
    private JPanel buildJList2() {
        JPanel panel = new JPanel(new BorderLayout());
        
        ListModel model = new ColourListModel();
        JList list = new JList(model);
        list.setSelectedIndex(0); // selects the first item
        
        int i = list.getSelectedIndex();
        String s = (String) list.getSelectedValue(); // need to cast

        panel.add(new JScrollPane(list));
        return panel;
    }
    
    private JPanel buildJTable() {
        JPanel panel = new JPanel(new BorderLayout());
        
        TableModel model = new ColourTableModel();
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        panel.add(new JScrollPane(table)); 
        
        return panel;
    }
    
    private JPanel buildJTree() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Create the root node
        DefaultMutableTreeNode continents =
                        new DefaultMutableTreeNode("Continents");

        // Create a node for Africa and add some sample countries
        DefaultMutableTreeNode africa =
                        new DefaultMutableTreeNode("Africa");
        africa.add(new DefaultMutableTreeNode("Kenya"));
        africa.add(new DefaultMutableTreeNode("Nigeria"));

        // Create a node for America and add some sample countries
        DefaultMutableTreeNode america =
                        new DefaultMutableTreeNode("America");
        america.add(new DefaultMutableTreeNode("Canada"));
        america.add(new DefaultMutableTreeNode("USA"));

        // Create a node for Asia and add some sample countries
        DefaultMutableTreeNode asia =
                        new DefaultMutableTreeNode("Asia");
        asia.add(new DefaultMutableTreeNode("China"));
        asia.add(new DefaultMutableTreeNode("Japan"));

        // Create a node for Australia and add some sample countries
        DefaultMutableTreeNode australia =
                        new DefaultMutableTreeNode("Australia");
        australia.add(new DefaultMutableTreeNode("Australia"));

        // Create a node for Europe and add some sample countries
        DefaultMutableTreeNode europe =
                        new DefaultMutableTreeNode("Europe");
        europe.add(new DefaultMutableTreeNode("France"));
        europe.add(new DefaultMutableTreeNode("Germany"));
        DefaultMutableTreeNode uk =
                        new DefaultMutableTreeNode("UK");
        uk.add(new DefaultMutableTreeNode("England"));
        uk.add(new DefaultMutableTreeNode("Northern Ireland"));
        uk.add(new DefaultMutableTreeNode("Scotland"));
        uk.add(new DefaultMutableTreeNode("Wales"));
        europe.add(uk);

        // Add the continents to the root node
        continents.add(africa);
        continents.add(america);
        continents.add(asia);
        continents.add(australia);
        continents.add(europe);

        // Create a JTree with the root node
        JTree tree = new JTree(continents);

        // Add the tree to the panel
        panel.add(new JScrollPane(tree));
        
        return panel;
    }
    
    private JPanel buildJSplitPane() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Panel to go on the left or the top
        JPanel panelOne = new JPanel();
        panelOne.add(new JLabel("This is panel 1"));

        // Panel to go on the right or the bottom
        JPanel panelTwo = new JPanel();
        panelTwo.add(new JLabel("This is panel 2"));

        // Split the panels
        JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                                   panelOne, panelTwo);
        panel.add(splitter);        
        return panel;
    }
    
    private JPanel buildJTabbedPane() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelOne = new JPanel();
        panelOne.add(new JLabel("This is the first panel"));

        JPanel panelTwo = new JPanel();
        panelTwo.add(new JLabel("This is the second panel"));

        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addTab("Tab 1", panelOne);
        tabPane.addTab("Tab 2", panelTwo);

        panel.add(tabPane);
        return panel;
    }
    
    private JPanel buildJDialog() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton showDialogButton = new JButton("Show dialog");
        showDialogButton.addActionListener(new ShowDialogButtonListener1());
        panel.add(showDialogButton);       

        return panel;
    }
    
    private JPanel buildJOptionPane1() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton showDialogButton = new JButton("Show dialog");
        showDialogButton.addActionListener(new ShowDialogButtonListener2());
        panel.add(showDialogButton);       

        return panel;
    }
    
    private JPanel buildJOptionPane2() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton showDialogButton = new JButton("Show dialog");
        showDialogButton.addActionListener(new ShowDialogButtonListener3());
        panel.add(showDialogButton);       

        return panel;
    }
    
    private JPanel buildJOptionPane3() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton showDialogButton = new JButton("Show dialog");
        showDialogButton.addActionListener(new ShowDialogButtonListener4());
        panel.add(showDialogButton);       

        return panel;
    }
    
    
    // Inner classes
    
    private class ColourSpinnerModel extends SpinnerListModel {
        
        public ColourSpinnerModel() {
            ArrayList<String> colours = new ArrayList<String>();
            colours.add("Red");
            colours.add("Green");
            colours.add("Blue");
            setList(colours);
        }
        
    }    
    
    
    private class ColourListModel extends DefaultListModel {

        private ArrayList<String> colours;

        public ColourListModel() {
            colours = new ArrayList<String>();
            colours.add("Red");
            colours.add("Green");
            colours.add("Blue");
        }

        @Override
        public Object getElementAt(int index) {
            return colours.get(index);
        }

        @Override
        public int getSize() {
            return colours.size();
        }

    }    

    private class ColourTableModel extends AbstractTableModel {

        private ArrayList<String> colours;

        public ColourTableModel() {
            colours = new ArrayList<String>();
            colours.add("Red");
            colours.add("Green");
            colours.add("Blue");
        }

        @Override
        public int getRowCount() {
            return colours.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Get the name of the colour at the required row index
            String colourName = colours.get(rowIndex);

            // Which column is required?
            switch (columnIndex) {
                case 0:
                    // First column - return name of colour
                    return colourName;

                case 1:
                    // Second column - return name in upper case
                    return colourName.toUpperCase();

                case 2:
                    // Third column - return number of characters in name
                    return colourName.length();

                default:
                        throw new IllegalStateException("columnIndex not "
                                + "valid " + columnIndex);
            }
        }
            
        @Override
        public String getColumnName(int columnIndex) {
            String[] columnHeaders = {"Colour",
                                      "Colour in Uppercase",
                                      "Number of Characters"};
            return columnHeaders[columnIndex];
        }
        
        @Override
        public Class getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return (columnIndex == 0);
        }
        
        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            colours.remove(rowIndex);
            colours.add(rowIndex, (String) value);
            fireTableDataChanged();
        }
    
    }    

    private class ShowDialogButtonListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialog = new JDialog(DemoUI.this, "My Dialog", true);
            dialog.setLayout(new FlowLayout());
            dialog.add(new JLabel("Name:"));
            dialog.add(new JTextField(20));
            dialog.add(new JButton("OK"));
            dialog.pack();
            dialog.setLocationRelativeTo(DemoUI.this);
            dialog.setVisible(true);
        }
    }    

    private class ShowDialogButtonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(DemoUI.this,
                        "This is some message text.", "Dialog Title",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }    

    private class ShowDialogButtonListener3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(DemoUI.this,
                    "Do you want to exit the program?", "End Program",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }    

    private class ShowDialogButtonListener4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String response = JOptionPane.showInputDialog(DemoUI.this,
                                    "Your name", "Name Entry",
                                    JOptionPane.QUESTION_MESSAGE);
            System.out.println(response);
        }
    }    
    
}
