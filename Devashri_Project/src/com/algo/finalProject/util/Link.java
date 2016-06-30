/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.finalProject.util;

/**
 * This class represents a linked list of all the 'Paths' that have been
 * traversed by the drone from its corresponding source
 *
 * @author Devashri
 */
public class Link {

    public PathNode first;

    public Link() {
        first = new PathNode();
    }

    /**
     * This method adds/enqueues a new path traveled by the drone to the linked
     * list The path is enqueued in the list in order of its confidence factor
     *
     * @param node
     */
    public void insertPathNode(PathNode nodeToBeInserted) {
        PathNode temp = first;
        PathNode previous = null;
        //to enqueue in order of traversal count
        while (temp != null && temp.getTraversalCount() < nodeToBeInserted.getTraversalCount()) {
            previous = temp;
            temp = temp.next;
        }
        //when linked list is empty
        if (previous == null) {
            nodeToBeInserted.next = temp;
            first = nodeToBeInserted;
        } else {
            nodeToBeInserted.next = temp;
            previous.next = nodeToBeInserted;

        }
    }

    public void sortLinkedListByTraversalCount(PathNode current) {
        PathNode head = current;
        PathNode insertionPointer = head;
        current = current.next;
        while (current != null) {
            insertionPointer = head;
            while (insertionPointer != current) {
                if (insertionPointer.traversalCount > current.traversalCount) {
                    int temp = current.traversalCount;
                    current.traversalCount = insertionPointer.traversalCount;
                    insertionPointer.traversalCount = temp;
                } else {
                    insertionPointer = insertionPointer.next;
                }
            }
            current = current.next;
        }
    }
}
