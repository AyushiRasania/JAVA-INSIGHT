package com.core;

import java.util.Scanner;

//   Create a program to reverse a string and check for palindromes.
public class P17_StringPalindrome {
    public static String reverseString(String str){
        StringBuffer reversed = new StringBuffer(str);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a String: ");
        String original = scanner.nextLine();

//        Reverse the String
        String reverse = reverseString(original);

//        Display the reverse string
        System.out.println("Reverse String is: "+reverse);

        if(original.equalsIgnoreCase(reverse)){
            System.out.println("This String is a palindromes");
        }else {
            System.out.println("This String is not a palindromes.");
        }
    }
}
