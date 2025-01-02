package com.core;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//   Create a program that reads from one file and writes the content to another file.
public class P41_FileReadWriteExample {
    public static void main(String[] args) {
        // Define the source and destination file paths
        String sourceFile = "source.txt";  // Replace with your source file path
        String destinationFile = "destination.txt";  // Replace with your destination file path

        // Use FileReader to read from the source file and FileWriter to write to the destination file
        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(destinationFile)) {

            // Read and write character by character
            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }

            System.out.println("Content successfully copied from source file to destination file.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file: " + e.getMessage());
        }
    }
}
