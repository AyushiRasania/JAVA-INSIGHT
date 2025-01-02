package com.core;

// Write a program to demonstrate exception handling using try-catch-finally.
public class P27_ExceptionHandlingExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30}; // Array with 3 elements
        int divisor = 0; // Will cause an arithmetic exception if used for division

        try {
            // Risky code that may throw exceptions
            System.out.println("Accessing an array element: " + numbers[3]); // ArrayIndexOutOfBoundsException
            System.out.println("Result of division: " + (numbers[1] / divisor)); // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block for array index errors
            System.out.println("Error: Array index out of bounds!");
            System.out.println("Exception message: " + e.getMessage());
        } catch (ArithmeticException e) {
            // Catch block for arithmetic errors
            System.out.println("Error: Division by zero is not allowed!");
            System.out.println("Exception message: " + e.getMessage());
        } finally {
            // Code that will execute no matter what
            System.out.println("Execution of finally block: Cleaning up resources or other final steps.");
        }

        // Code after try-catch-finally
        System.out.println("Program continues execution after exception handling.");
    }
}

