package com.core;

//  Write a program that implements multiple interfaces in a single class
//  interface1
interface Printable {
    void print();// Abstract method to print details
}

//  interface2
interface Scannable {
    void scan();// Abstract method to scan details
}

// Concrete class implementing multiple interfaces
class MultiFunctionDevice implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("Printing a document...!");
    }

    @Override
    public void scan() {
        System.out.println("Scanning a document...!");
    }
}

public class P23_MultipleInterfaceExample {
    public static void main(String[] args) {
        // Create an object of MultifunctionDevice
        MultiFunctionDevice multiFunctionDevice = new MultiFunctionDevice();

        // Call methods from both interfaces
        multiFunctionDevice.scan();
        multiFunctionDevice.print();
    }
}
