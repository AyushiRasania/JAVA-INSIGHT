package com.core;

import java.util.Scanner;
//   Implement string comparison using equals() and compareTo() methods.
public class P18_StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First String: ");
        String string1 = scanner.nextLine();

        System.out.println("Enter Second String");
        String string2=scanner.nextLine();

//        using equal() method
        if (string1.equals(string2)){
            System.out.println("The Strings are equal using equal().");
        }else {
            System.out.println("The Strings are not equal using equal().");
        }

//        using compareTo() method
        int comparisonResult = string1.compareTo(string2);
        if (comparisonResult == 0) {
            System.out.println("The strings are equal using compareTo().");
        } else if (comparisonResult < 0) {
            System.out.println("The first string is lexicographically smaller than the second string.");
        } else {
            System.out.println("The first string is lexicographically larger than the second string.");
        }
    }
}
