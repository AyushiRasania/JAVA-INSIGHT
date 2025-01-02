package com.core;

//   Create a user-defined package and import it into another program
import com.core1.MathOperation;

public class P25_UserDefinedPackageExample {
    public static void main(String[] args) {
        // Create an object of the MathOperations class
        MathOperation mathOperation =new MathOperation();

        // Perform operations
        int sum = mathOperation.add(10, 20);
        int dif = mathOperation.sub(50, 40);

        // Print results
        System.out.println("Addition: "+sum);
        System.out.println("subtraction: "+dif);
    }
}
