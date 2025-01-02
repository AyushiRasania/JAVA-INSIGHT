package com.core;

import java.util.HashMap;
import java.util.Map;

//   Create a HashMap to store and retrieve key-value pairs.
public class P38_HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap to store key-value pairs
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        map.put("Mango", 4);

        // Display the HashMap
        System.out.println("HashMap with key-value pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Retrieving values using keys
        System.out.println("\nValue associated with 'Apple': " + map.get("Apple"));
        System.out.println("Value associated with 'Banana': " + map.get("Banana"));

        // Checking if a key exists
        if (map.containsKey("Mango")) {
            System.out.println("\n'Mango' exists in the map.");
        }

        // Checking if a value exists
        if (map.containsValue(3)) {
            System.out.println("'3' exists as a value in the map.");
        }

        // Removing a key-value pair
        map.remove("Orange");
        System.out.println("\nHashMap after removing 'Orange':");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Size of the HashMap
        System.out.println("\nSize of the HashMap: " + map.size());
    }

}
