/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.finalProject.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is a utility class which consists of helper methods
 *
 * @author Devashri
 */
public class Utility {

    /**
     * This method is used to create anomalies on random nodes
     *
     * @param nodeComponentMap
     * @return
     */
    public int createAnomalies(HashMap<String, Node> nodeComponentMap) {

        int numberOfAnnomalies = 0 + (int) (Math.random() * 300);

        for (int i = 0; i < numberOfAnnomalies; i++) {

            int annomalyAtX = 0 + (int) (Math.random() * 20);
            int annomalyAtY = 0 + (int) (Math.random() * 20);
            StringBuilder sb = new StringBuilder();
            sb.append(getStringFromDigit(annomalyAtX));
            sb.append(getStringFromDigit(annomalyAtY).substring(0, 1).toUpperCase());
            sb.append(getStringFromDigit(annomalyAtY).substring(1));
            Node node = nodeComponentMap.get(sb.toString());
            int sum = annomalyAtX + annomalyAtY;
            if (sum % 2 == 0) {
                nodeComponentMap.get(sb.toString()).setLowIntensityAnomalyPresent(true);
            } else {

                nodeComponentMap.get(sb.toString()).setHighIntensityAnomalyPresent(true);
            }

        }
        return numberOfAnnomalies;
    }

    /**
     * This method is used to delete anomalies from nodes so that new ones can
     * be generated in the next timer run
     *
     * @param nodeComponentMap
     */
    public void deleteAnomalies(HashMap<String, Node> nodeComponentMap) {

        for (Node node : nodeComponentMap.values()) {
            // System.err.println("node" + node.getxCoOrdinate() + node.isAnomalyPresent());
            if (node.isHighIntensityAnomalyPresent()) {
                //   System.out.println("in delete if");

                node.setHighIntensityAnomalyPresent(false);
            }

            if (node.isLowIntensityAnomalyPresent()) {
                node.setLowIntensityAnomalyPresent(false);
            }

        }

    }

    /**
     * This method is used to associate every node to its corresponding jLabel
     * according to its names
     *
     * @return
     */
    public HashMap<String, Node> createMatrix() {

        HashMap<String, Node> labelNodeMap = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                Node node = new Node();
                StringBuilder sb = new StringBuilder();
                String x = getStringFromDigit(i);
                sb.append(x);
                node.setxCoOrdinate(x);
                String y = getStringFromDigit(j).substring(0, 1).toUpperCase() + getStringFromDigit(j).substring(1);
                sb.append(y);
                node.setyCoOrdinate(y);
                node.setX(i);
                node.setY(j);
                node.setNodeName(sb.toString());
                labelNodeMap.put(sb.toString(), node);
            }

        }
        return labelNodeMap;

    }

    /**
     * This method is used to initialize the data set which is capable of
     * learning
     *
     * @param labelNodeMap
     * @param machine
     */
    public void initialiseMachine(HashMap<String, Node> labelNodeMap, Machine machine) {
        PathNode pathNode = new PathNode();
        pathNode.traversalCount = 0;
        pathNode.fuelConsumed = 70;

        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            StringBuffer sb = new StringBuffer();
            sb.append(getStringFromDigit(i));
            sb.append(getStringFromDigit(i).substring(0, 1).toUpperCase());
            sb.append(getStringFromDigit(i).substring(1));
            Node node = labelNodeMap.get(sb.toString());
            nodeList.add(node);
        }
        pathNode.listOfNodes = nodeList;
        Node source = labelNodeMap.get("zeroZero");
        Link link = new Link();
        link.insertPathNode(pathNode);
        machine.dataSet.put(source, link);

    }

    /**
     * This method is used to print data set used for machine learning
     *
     * @param mapOfNode
     */
    public void printMap(HashMap<Node, Link> mapOfNode) {

        for (HashMap.Entry<Node, Link> entry : mapOfNode.entrySet()) {

            Node node = entry.getKey();
            System.err.println("KEY:" + node.getNodeName());
            Link link = mapOfNode.get(node);
            PathNode tmp = link.first;
            while (tmp != null) {

                for (Node node1 : tmp.listOfNodes) {
                    System.out.print(node.getNodeName() + "\t");
                }
                System.out.println(tmp.listOfNodes);
                tmp = tmp.getNext();

            }

        }
    }

    /**
     * This method is used to retrieve a string name of a digit from its
     * corresponding value
     *
     * @param digit
     * @return
     */
    public String getStringFromDigit(int digit) {

        String digitToString = "";
        switch (digit) {
            case 0:
                digitToString = "zero";
                break;
            case 1:
                digitToString = "one";
                break;
            case 2:
                digitToString = "two";
                break;
            case 3:
                digitToString = "three";
                break;
            case 4:
                digitToString = "four";
                break;
            case 5:
                digitToString = "five";
                break;
            case 6:
                digitToString = "six";
                break;
            case 7:
                digitToString = "seven";
                break;
            case 8:
                digitToString = "eight";
                break;
            case 9:
                digitToString = "nine";
                break;
            case 10:
                digitToString = "ten";
                break;
            case 11:
                digitToString = "eleven";
                break;
            case 12:
                digitToString = "twelve";
                break;
            case 13:
                digitToString = "thirteen";
                break;
            case 14:
                digitToString = "fourteen";
                break;
            case 15:
                digitToString = "fifteen";
                break;
            case 16:
                digitToString = "sixteen";
                break;
            case 17:
                digitToString = "seventeen";
                break;
            case 18:
                digitToString = "eighteen";
                break;
            case 19:
                digitToString = "nineteen";
                break;
            default:
                digitToString = "Invalid month";
                break;
        }
        return digitToString;

    }
    
    public void printMap(Machine machine) {
        
        HashMap<Node, Link> dataSet = machine.getDataSet();
        
        for (HashMap.Entry<Node, Link> entry : dataSet.entrySet()) {

            Node key = entry.getKey();
            System.out.println("Source : " + key);
            System.out.println("Path Nodes" + entry.getValue().toString());

        }

    }

}
