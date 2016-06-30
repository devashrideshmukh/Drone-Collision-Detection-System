/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.finalProject.util;

import java.util.ArrayList;

/**
 * This class represents a set of all the nodes traversed by a node in one run
 * It also stores the traversal count i.e. the number of times path is traversed
 * and the fuel it consumes
 * @author Devashri
 */
public class PathNode {

    ArrayList<Node> listOfNodes;
    int traversalCount=0;
    float fuelConsumed;
    PathNode next;

    public PathNode() {
        listOfNodes=new ArrayList<>();
    }
    
    

    public void addNodeToPathNode(Node node) {
        listOfNodes.add(node);
    }

    public PathNode getNext() {
        return next;
    }

    public void setNext(PathNode next) {
        this.next = next;
    }

    public ArrayList<Node> getListOfNodes() {
        return listOfNodes;
    }

    public void setListOfNodes(ArrayList<Node> listOfNodes) {
        this.listOfNodes = listOfNodes;
    }

    public int getTraversalCount() {
        return traversalCount;
    }

    public void setTraversalCount(int traversalCount) {
        this.traversalCount = traversalCount;
    }

    public float getFuel() {
        return fuelConsumed;
    }

    public void setFuel(float fuel) {
        this.fuelConsumed = fuel;
    }

}
