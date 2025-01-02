package com.core;

import java.util.ArrayList;
import java.util.LinkedList;

//   Write a program that demonstrates the use of an ArrayList andLinkedList.
public class P36_ListExample {
    public static void main(String[] args) {

        // Create an ArrayList and perform operations
        ArrayList<String> arrayList = new ArrayList<>();

        // Adding elements to ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add("Mango");

        // Display ArrayList elements
        System.out.println("ArrayList elements:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // Remove an element from ArrayList
        arrayList.remove("Banana");
        System.out.println("\nArrayList after removing 'Banana':");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // Accessing an element by index
        System.out.println("\nAccessing element at index 1 in ArrayList: " + arrayList.get(1));


        // Create a LinkedList and perform operations
        LinkedList<String> linkedList = new LinkedList<>();

        // Adding elements to LinkedList
        linkedList.add("Tom");
        linkedList.add("Jerry");
        linkedList.add("Spike");
        linkedList.add("Butch");

        // Display LinkedList elements
        System.out.println("\nLinkedList elements:");
        for (String name : linkedList) {
            System.out.println(name);
        }

        // Remove an element from LinkedList
        linkedList.remove("Jerry");
        System.out.println("\nLinkedList after removing 'Jerry':");
        for (String name : linkedList) {
            System.out.println(name);
        }

        // Accessing an element by index
        System.out.println("\nAccessing element at index 1 in LinkedList: " + linkedList.get(1));

        // Add an element to the beginning of the LinkedList (similar to push in Stack)
        linkedList.addFirst("Tommy");
        System.out.println("\nLinkedList after adding 'Tommy' to the beginning:");
        for (String name : linkedList) {
            System.out.println(name);
        }

        // Add an element to the end of the LinkedList (similar to enqueue in Queue)
        linkedList.addLast("Clifford");
        System.out.println("\nLinkedList after adding 'Clifford' to the end:");
        for (String name : linkedList) {
            System.out.println(name);
        }
    }
}
