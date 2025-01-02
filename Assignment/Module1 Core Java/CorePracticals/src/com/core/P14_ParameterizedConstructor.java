package com.core;

//   Write a program to create and initialize an object using a parameterized constructor.
class ParameterConstructor {
    int id;
    String name;

    public ParameterConstructor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("id is: " + id);
        System.out.println("name is: " + name);
    }
}

public class P14_ParameterizedConstructor {
    public static void main(String[] args) {
        ParameterConstructor constructor = new ParameterConstructor(1, "Ayushi");
        ParameterConstructor constructor1 = new ParameterConstructor(2, "Harshil");
        constructor.displayDetails();
        constructor1.displayDetails();
    }
}
