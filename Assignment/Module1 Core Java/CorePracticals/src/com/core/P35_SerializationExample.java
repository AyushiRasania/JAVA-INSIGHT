package com.core;

import java.io.*;

// A class representing a simple object to be serialized
class Person2 implements Serializable {
    private String name;
    private int age;

    // Constructor
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Display information about the person
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class P35_SerializationExample {
    // Method to serialize the object
    public static void serializeObject(Person2 person, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(person); // Writing the object to a file
            System.out.println("Object has been serialized.");
        } catch (IOException e) {
            System.out.println("IOException during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize the object
    public static Person2 deserializeObject(String fileName) {
        Person2 person = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            person = (Person2) in.readObject(); // Reading the object from the file
            System.out.println("Object has been deserialized.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IOException or ClassNotFoundException during deserialization: " + e.getMessage());
        }
        return person;
    }

    public static void main(String[] args) {
        String fileName = "person.ser"; // File to store serialized object

        // Create a person object to serialize
        Person2 person = new Person2("Alice", 30);

        // Serialize the person object
        serializeObject(person, fileName);

        // Deserialize the object from the file
        Person2 deserializedPerson = deserializeObject(fileName);

        // Display information about the deserialized person
        if (deserializedPerson != null) {
            deserializedPerson.displayInfo();
        }
    }
}
