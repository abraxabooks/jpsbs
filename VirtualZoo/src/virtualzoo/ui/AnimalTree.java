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
import javax.swing.tree.*;

public class AnimalTree extends JTree implements AnimalListener {

    private ZooAdministrator admin;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode root;

    public AnimalTree() {
        admin = ZooAdministrator.getInstance();
        root = new DefaultMutableTreeNode("Animals");
        model = new DefaultTreeModel(root);
        setModel(model);
        buildTree();
        expandNodes();
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }

    private void buildTree() {
        root.removeAllChildren();
        Collection<Pen> pens = new TreeSet<Pen>(admin.getPens());
        for (Pen pen : pens) {
            DefaultMutableTreeNode node =
                    new DefaultMutableTreeNode(pen);
            buildAnimalTreeNodes(pen, node);
            root.add(node);
        }
    }

    private void buildAnimalTreeNodes(Pen pen,
            DefaultMutableTreeNode node) {
        Collection<Animal> animals =
                new TreeSet<Animal>(admin.getAnimals(pen));
        for (Animal animal : animals) {
            node.add(new DefaultMutableTreeNode(animal));
        }
    }

    private void expandNodes() {
        for (int i = 0; i < getRowCount(); i++) {
            expandRow(i);
        }
    }

    @Override
    public void animalCreated(AnimalEvent event) {
        DefaultMutableTreeNode animalNode =
                new DefaultMutableTreeNode(event.getAnimal());
        Pen pen = event.getAnimal().getPen();
        DefaultMutableTreeNode parentNode = getTreeNode(pen);
        model.insertNodeInto(animalNode, parentNode, parentNode.getChildCount());
        buildTree();
        model.reload();
        expandNodes();
    }

    @Override
    public void animalChanged(AnimalEvent event) {
        model.reload();
        expandNodes();
    }

    @Override
    public void animalRemoved(AnimalEvent event) {
        buildTree();
        model.reload();
        expandNodes();
    }
    
    private DefaultMutableTreeNode getTreeNode(Pen pen) {
        Enumeration penNodes = root.children();
        while (penNodes.hasMoreElements()) {
            DefaultMutableTreeNode penNode = 
                            (DefaultMutableTreeNode) penNodes.nextElement();
            Pen penNodePen = (Pen) penNode.getUserObject();
            if (penNodePen.equals(pen)) return penNode;
        }
        throw new IllegalArgumentException(pen + " not found");
    }
}