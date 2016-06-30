/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.finalProject.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents the drone which is responsible for collision detection
 * @author Devashri
 */
public class Drone {

    private static Drone drone;
    private Node currentNode;
    private Node previousNode;
    private Node source;
    private Node destination;
    private float fuel;
    private HashMap<String, Node> labelNodeMap;
    ArrayList<Node> currentPath;
    ArrayList<Node> traversedPath;
    Utility utility = new Utility();

    private Drone() {

        currentPath = new ArrayList<>();
        traversedPath = new ArrayList<>();
        fuel = 100;
        labelNodeMap = utility.createMatrix();

    }

    //singleton design pattern
    public static Drone getInstance() {
        if (drone == null) {
            drone = new Drone();
        }
        return drone;
    }

    public ArrayList<Node> getTraversedPath() {
        return traversedPath;
    }

    public void setTraversedPath(ArrayList<Node> traversedPath) {
        this.traversedPath = traversedPath;
    }

    public HashMap<String, Node> getLabelNodeMap() {
        return labelNodeMap;
    }

    public void setLabelNodeMap(HashMap<String, Node> labelNodeMap) {
        this.labelNodeMap = labelNodeMap;
    }

    public ArrayList<Node> getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(ArrayList<Node> currentPath) {
        this.currentPath = currentPath;
    }

    /**
     * This method finds the smallest distance node of all the adjacent nodes of
     * a node It uses distance formula to calculate the minimum distance of each
     * adjacent node from the destination and then computes the smallest
     * distance node and returns it
     *
     * @param currentNode
     * @return
     */
    public Node getSmallestDistanceNode(Node currentNode) {

        ArrayList<Node> adjacentNodes = getAdjacentNodes(currentNode);
        int xTwo = destination.getX();
        int yTwo = destination.getY();
        double smallestDistance = 100;
        Node smallestDistanceNode = null;
        for (Node adjacentNode : adjacentNodes) {

            if (!adjacentNode.isHighIntensityAnomalyPresent()) {
                int xOne = adjacentNode.getX();
                int yOne = adjacentNode.getY();
               
                //applying distance formula
                System.out.println("" + adjacentNode.isHighIntensityAnomalyPresent());
                double distance = Math.sqrt((xTwo - xOne) * (xTwo - xOne) + (yTwo - yOne) * (yTwo - yOne));

                System.out.println("distance of" + adjacentNode.getNodeName() + "is" + distance);

                if (distance <= smallestDistance) {

                    smallestDistance = distance;
                    smallestDistanceNode = adjacentNode;

                }

            }

        }
        return smallestDistanceNode;

    }

    /**
     * This method takes in a node from the grid It dynamically populates its
     * adjacent nodes and returns a list of all the adjacent nodes
     *
     * @param currentNode
     * @return
     */
    public ArrayList<Node> getAdjacentNodes(Node currentNode) {
        ArrayList<Node> adjacentNodeList = new ArrayList<>();
        int x = currentNode.getX();
        int y = currentNode.getY();

        if (x == 0 && y == 0) {
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));

        } else if (x == 19 && y == 0) {
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));

        } else if (x == 0 && y == 19) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));

        } else if (x == 19 && y == 19) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));

        } else if (x == 0 && (y > 0 || y < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));

        } else if (y == 0 && (x > 0 || x < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));

        } else if (x == 19 && (y > 0 || y < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));

        } else if (y == 19 && (x > 0 || x < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));

        } else {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));

        }

        return adjacentNodeList;
    }

    /**
     * This method takes in the X and Y co-ordinates of a node and returns the
     * node itself from the label-node map
     *
     * @param x
     * @param y
     * @return
     */
    public Node returnNodeFromCoOrdinates(int x, int y) {
        String xCoOrdinate = utility.getStringFromDigit(x);
        String yCoOrdinate = utility.getStringFromDigit(y).substring(0, 1).toUpperCase() + utility.getStringFromDigit(y).substring(1);
        StringBuilder sb = new StringBuilder();
        sb.append(xCoOrdinate);
        sb.append(yCoOrdinate);
        Node node = labelNodeMap.get(sb.toString());
        return node;

    }

    

    /**
     * This method is used to make the drone fly Each time this method is
     * invoked the adjacent nodes of the current node are populated dynamically
     * and the node with the minimum distance is set as the next node to be
     * jumped on
     *
     * @return
     */
    public boolean fly() {
        boolean flag = false;
        ArrayList<Node> adjacentNodes = getAdjacentNodes(drone.currentNode);
        System.out.println("This node has \t" + adjacentNodes.size()+"adjacent nodes");
        System.out.println("");
        int xTwo = drone.destination.getX();
        int yTwo = drone.destination.getY();
        double smallestDistance = 100;
        Node smallestDistanceNode = null;
        
        //retrieve all adjacent nodes
        for (Node adjacentNode : adjacentNodes) {
            
            //check if anomaly is present
            if (!adjacentNode.isHighIntensityAnomalyPresent()) {
                int xOne = adjacentNode.getX();
                int yOne = adjacentNode.getY();
                
                //applying distance formula to check the node with the minimum distance
                double distance = Math.sqrt((xTwo - xOne) * (xTwo - xOne) + (yTwo - yOne) * (yTwo - yOne));

                System.out.println("Distance of\t" + adjacentNode.getNodeName() + "\t is \t" + distance);

                //select the node with the smallest node
                if (distance <= smallestDistance) {

                    smallestDistance = distance;
                    smallestDistanceNode = adjacentNode;

                }

            }

        }

        drone.setPreviousNode(drone.currentNode);
        drone.currentNode.setVisited(true);
        drone.previousNode.setVisited(true);
        drone.setCurrentNode(smallestDistanceNode);
       
        
        
        //if the source reaches destination
        if (drone.currentNode.equals(drone.destination)) {

            flag = true;
           
        } else {

            flag = false;
        }
        return flag;

    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }
    

}
