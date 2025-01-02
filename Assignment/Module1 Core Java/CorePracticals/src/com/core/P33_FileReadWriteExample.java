package com.core;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P33_FileReadWriteExample {
    public static void main(String[] args) {
        String filePath = "example.txt"; // File path

        // Writing to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello, this is a sample text.\n");
            writer.write("FileReader and FileWriter example in Java.\n");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // Reading from the file
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            System.out.println("Reading content from the file:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character); // Print each character
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}
