package com.core;

import java.util.Scanner;

//   Write a program to read input from the console using Scanner.
public class P39_ConsoleInputExample {
    public static void main(String[] args) {

        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read a string input from the user
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Read an integer input from the user
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Read a floating-point number (float)
        System.out.print("Enter your height (in meters): ");
        float height = scanner.nextFloat();

        // Display the input data
        System.out.println("\nYour name: " + name);
        System.out.println("Your age: " + age);
        System.out.println("Your height: " + height + " meters");

        // Close the scanner object to avoid resource leak
        scanner.close();
    }
}
