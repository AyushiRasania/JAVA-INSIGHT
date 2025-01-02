package com.core;

import java.util.Scanner;

// Write a program to display the Fibonacci series using a loop
public class P06_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of term in fibonacci series:");
        int number = scanner.nextInt();

        System.out.println("Fibonacci series up to "+number+" terms: ");

        int first = 0, second = 1;
        for (int i=0;i<=number;i++){
            System.out.println(first+ " ");

            //calculation
            int next = first + second; // 0+1 =1
            first = second;//0=1
            second = next;

        }
        scanner.close();
    }
}
