package com.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//   Implement a program using HashSet to remove duplicate elements from a list.
public class P37_RemoveDuplicatesExample {
    public static void main(String[] args) {
        // Create a List with duplicate elements
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("Apple");
        listWithDuplicates.add("Banana");
        listWithDuplicates.add("Orange");
        listWithDuplicates.add("Apple");
        listWithDuplicates.add("Mango");
        listWithDuplicates.add("Banana");

        System.out.println("List before removing duplicates:");
        for (String item : listWithDuplicates) {
            System.out.println(item);
        }

        // Use a HashSet to remove duplicates
        Set<String> setWithoutDuplicates = new HashSet<>(listWithDuplicates);

        // Convert the HashSet back to a List (if needed)
        List<String> listWithoutDuplicates = new ArrayList<>(setWithoutDuplicates);

        // Display the List after removing duplicates
        System.out.println("\nList after removing duplicates:");
        for (String item : listWithoutDuplicates) {
            System.out.println(item);
        }
    }
}
