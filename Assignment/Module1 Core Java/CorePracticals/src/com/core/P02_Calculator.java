package com.core;

import java.util.Scanner;

// Create a calculator using arithmetic and relational operators
public class P02_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*****Calculator*****:");
        System.out.println("1. Addition ");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.println("Select an Option: ");
        int choice = sc.nextInt();

        int a, b, c;

        switch (choice) {
            case 1:
                System.out.println("Enter First Value: ");
                a = sc.nextInt();
                System.out.println("Enter Second Value: ");
                b = sc.nextInt();
                c = a + b;
                System.out.println("*******************");
                System.out.println("Addition : " + c);
                break;

            case 2:
                System.out.println("Enter First Value: ");
                a = sc.nextInt();
                System.out.println("Enter Second Value: ");
                b = sc.nextInt();
                c = a - b;
                System.out.println("*******************");
                System.out.println("Subtraction : " + c);
                break;

            case 3:
                System.out.println("Enter First Value: ");
                a = sc.nextInt();
                System.out.println("Enter Second Value: ");
                b = sc.nextInt();
                c = a * b;
                System.out.println("*******************");
                System.out.println("Multiplication : " + c);
                break;

            case 4:
                System.out.println("Enter First Value: ");
                a = sc.nextInt();
                System.out.println("Enter Second Value: ");
                b = sc.nextInt();
                if (b != 0) {
                    c = a / b;
                    System.out.println("*******************");
                    System.out.println("Division : " + c);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;

            default:
                System.out.println("Invalid Input");
//                break; // Ensure the program stops here and does not proceed further
        }
    }
}
