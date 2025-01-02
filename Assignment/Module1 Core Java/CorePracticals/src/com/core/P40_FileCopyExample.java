package com.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//  Implement a file copy program using FileInputStream and FileOutputStream
public class P40_FileCopyExample{
    public static void main(String[] args) {
        // Define source and destination file paths
        String sourceFile = "source.txt";  // Replace with your source file path
        String destinationFile = "destination.txt";  // Replace with your destination file path

        // Use FileInputStream and FileOutputStream to copy the file
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile);
             ) {

            // Read and write byte by byte
            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                outputStream.write(byteData);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred during file copy: " + e.getMessage());
        }
    }
}
