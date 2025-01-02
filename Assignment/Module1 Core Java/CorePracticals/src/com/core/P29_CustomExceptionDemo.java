package com.core;

import java.util.Scanner;

//  Create a custom exception class and use it in your program.
public class P29_CustomExceptionDemo {
    // Method to check age eligibility
    public static void checkEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older to vote.");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get age input from user
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Call the method to check eligibility
            checkEligibility(age);
        } catch (InvalidAgeException e) {
            // Handle the custom exception
            System.out.println("Caught an exception: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
            scanner.close();
        }
    }
}
