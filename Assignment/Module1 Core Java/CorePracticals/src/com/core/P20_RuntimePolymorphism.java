package com.core;

//  Implement runtime polymorphism by overriding methods in the child class.
class Shape{
    public void draw(){
        System.out.println("Drawing a shape");
    }
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}
public class P20_RuntimePolymorphism {
    public static void main(String[] args) {
        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Triangle();
        shape.draw();

        shape=new Square();
        shape.draw();
    }
}
