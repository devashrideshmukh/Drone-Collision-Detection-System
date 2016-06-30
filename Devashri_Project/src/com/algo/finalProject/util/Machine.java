/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.finalProject.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * This class is used to represent a machine which learns the path traversed by
 * a drone It consists of a data set which represents a 'Source' node and its
 * corresponding Linkedlist consisting of all its traversed paths in order of
 * their confidence factor
 *
 * @author Devashri
 */
public class Machine {

    //this is the data set used to store source and its corresponding paths in order of their confidence factor
    HashMap<Node, Link> dataSet;

    public Machine() {

        dataSet = new HashMap<>();

    }

    public HashMap<Node, Link> getDataSet() {
        return dataSet;
    }

    public void setDataSet(HashMap<Node, Link> dataSet) {
        this.dataSet = dataSet;
    }

}
