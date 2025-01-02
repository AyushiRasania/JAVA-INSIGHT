package com.core;

//   Implement method overloading by creating methods for different data types.
public class P09_MethodOverLoading {
    //     Method to calculate the square of an integer
    public static int square(int number) {
        return number * number;
    }

    //     Method to calculate the square of a double
    public static double square(double number) {
        return number * number;
    }

    //     Method to calculate the square of a float
    public static float square(float number) {
        return number * number;
    }

    //     Method to calculate the square of a long
    public static long square(long number) {
        return number * number;
    }

    public static void main(String[] args) {
// Testing method overloading with different data types
        int intValue = 5;
        double doubleValue = 2.0;
        float floatValue = 3.0f;
        long longValue = 10L;

        System.out.println("Square of integer value " + intValue + " is: " + square(intValue));
        System.out.println("Square of double value " + doubleValue + " is: " + square(doubleValue));
        System.out.println("Square of float value " + floatValue + " is: " + square(floatValue));
        System.out.println("Square of long value " + longValue + " is: " + square(longValue));
    }

}
