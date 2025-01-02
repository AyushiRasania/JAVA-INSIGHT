package com.core;

//   Write a program demonstrating single inheritance.
class Parents {
    public void show() {
        System.out.println("Java is a backend language");
    }
}

class Child extends Parents {
    public void display() {
        System.out.println("Angular is a fronted language");
    }
}

public class P11_SingleInheritance {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
        child.show();
    }
}
