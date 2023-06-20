package Q2;//-----------------------------------------------------
// Title: Circular Linked List and Node Classes
// Authors: Burak Koç - Furkan Safa Altunyuva
// Section: 4
// Assignment: 3
// Description: This class is a basic linked list class with tail- head connection.
//-----------------------------------------------------

public class CircularLL {

    // node class
    public class Node {
        int data; // data stored
        Node next; // reference

        // constructor to create a new node with the given data
        public Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    // method to add a new node with the given data to the circular linked list
    public void add(int data) {
        Node newNode = new Node(data); // create a new node with the given data
        if (head == null) {
            // if the circular linked list is empty, make the new node as the head and tail
            head = newNode;
            tail = newNode;
            newNode.next = head; // set the next reference of the new node to itself (circular reference)
        } else {
            tail.next = newNode; // set the next reference of the tail node to the new node
            tail = newNode; // update the tail to the new node
            tail.next = head; // set the next reference of the tail node to the head (maintaining circularity)
        }
    }
}
