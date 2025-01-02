package com.core;

import java.util.Scanner;

// Write a program to find if a number is even or odd using an if-else statement.
public class P04_OddEven {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Any Number: ");
        n = scanner.nextInt();
        if (n%2==0){
            System.out.println(n+ " Number is Even.");
        }else{
            System.out.println(n+ " Number is odd.");
        }
    }

}
