package com.core;

public class InvalidAgeException extends Exception{
    // Constructor
    public InvalidAgeException(String message) {
        super(message); // Call the superclass constructor with the custom message
    }
}
