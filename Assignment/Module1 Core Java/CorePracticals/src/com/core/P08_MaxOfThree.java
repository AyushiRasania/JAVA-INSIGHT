package com.core;

import java.util.Scanner;

// Write a program to find the maximum of three numbers using a method.
public class P08_MaxOfThree {
    public static int findMaximum(int num1, int num2, int num3) {
//        compare three numbers and return the largest
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Input three numbers
        System.out.println("Enter First Number: ");
        int number1 = scanner.nextInt();

        System.out.println("Enter Second Number: ");
        int number2 = scanner.nextInt();

        System.out.println("Enter Third Number: ");
        int number3 = scanner.nextInt();

//         Call the method to find the maximum and print the result
        int max = findMaximum(number1, number2, number3);
        System.out.println("The maximum of the three number is: " + max);
    }
}
