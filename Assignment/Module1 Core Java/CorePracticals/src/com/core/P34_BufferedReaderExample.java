package com.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//   Implement a program that reads a file line by line using BufferedReader.
public class P34_BufferedReaderExample {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Path to the file

        // Reading the file line by line
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading content from the file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
