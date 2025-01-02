package com.core;

//   Implement multiple catch blocks for different types of exceptions.
public class P28_MultipleCatchExample {
    public static void main(String[] args) {
        try {
            // Risky code that may throw exceptions
            int[] numbers = {1, 2, 3};
            int result = numbers[1] / 0; // May throw ArithmeticException
            System.out.println("Result: " + result);

            String text = null;
            System.out.println("String length: " + text.length()); // May throw NullPointerException

            System.out.println("Accessing element: " + numbers[5]); // May throw ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            // Catch block for division by zero
            System.out.println("Error: ArithmeticException - Division by zero!");
            System.out.println("Exception details: " + e.getMessage());
        } catch (NullPointerException e) {
            // Catch block for null pointer access
            System.out.println("Error: NullPointerException - Attempted to access a null object!");
            System.out.println("Exception details: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block for invalid array index access
            System.out.println("Error: ArrayIndexOutOfBoundsException - Invalid array index!");
            System.out.println("Exception details: " + e.getMessage());
        } finally {
            // Code that will always execute
            System.out.println("Execution of finally block: Final cleanup or logging.");
        }

        // Code after exception handling
        System.out.println("Program continues after exception handling.");
    }
}
