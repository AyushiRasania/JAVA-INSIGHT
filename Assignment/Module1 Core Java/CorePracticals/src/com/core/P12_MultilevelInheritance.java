package com.core;

//  Create a class hierarchy and demonstrate multilevel inheritance.
class Animal {
    public void eat() {
        System.out.println("Animals can eat");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog can bark");
    }
}

class Cat extends Dog {
    public void cry() {
        System.out.println("Cat can cry");
    }
}

public class P12_MultilevelInheritance {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.cry();
        cat.bark();
        cat.eat();
    }

}
