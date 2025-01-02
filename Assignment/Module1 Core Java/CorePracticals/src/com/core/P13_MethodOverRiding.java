package com.core;

//   Implement method overriding to show polymorphism in action.
class Vehicle {
    public void run() {
        System.out.println("The Vehicle is running");
    }
}

class Car extends Vehicle {
    @Override
    public void run() {
        System.out.println("The car is running safely on the road");
    }
}

class Bike extends Vehicle {
    @Override
    public void run() {
        System.out.println("The bike is running smoothly on the track");
    }
}

public class P13_MethodOverRiding {
    public static void main(String[] args) {
        Vehicle vehicle = new Bike();
        vehicle.run();

        Vehicle vehicle1 = new Car();
        vehicle1.run();

//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.run();
    }
}
