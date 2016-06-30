/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.finalProject.util;

import javax.swing.JLabel;

/**
 * This class represents each node of the grid on which drone has to travel
 * It has properties such as X and Y co-ordinates representing its location
 * Its properties also indicate if they have high/low intensity anomalies
 * @author Devashri
 */
public class Node {

    
    private int x;
    private int y;
    private String xCoOrdinate;
    private String yCoOrdinate;
    private String nodeName;
    private JLabel label;
    private boolean highIntensityAnomalyPresent = false;
    private boolean lowIntensityAnomalyPresent = false;
    private boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isHighIntensityAnomalyPresent() {
        return highIntensityAnomalyPresent;
    }

    public void setHighIntensityAnomalyPresent(boolean highIntensityAnomalyPresent) {
        this.highIntensityAnomalyPresent = highIntensityAnomalyPresent;
    }

    public boolean isLowIntensityAnomalyPresent() {
        return lowIntensityAnomalyPresent;
    }

    public void setLowIntensityAnomalyPresent(boolean lowIntensityAnomalyPresent) {
        this.lowIntensityAnomalyPresent = lowIntensityAnomalyPresent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public String getxCoOrdinate() {
        return xCoOrdinate;
    }

    public void setxCoOrdinate(String xCoOrdinate) {
        this.xCoOrdinate = xCoOrdinate;
    }

    public String getyCoOrdinate() {
        return yCoOrdinate;
    }

    public void setyCoOrdinate(String yCoOrdinate) {
        this.yCoOrdinate = yCoOrdinate;
    }

    @Override
    public String toString() {
        return nodeName;
    }
    
    

}
