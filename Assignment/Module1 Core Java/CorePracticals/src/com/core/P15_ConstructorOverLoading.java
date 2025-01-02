package com.core;

//   Demonstrate constructor overloading by passing different types of parameters.
class ConstructorOverloading{
    String name;
    int age;
//    Different types of parameters and this is a constructor overloading
    public ConstructorOverloading(){
        this.name="Asha";
        this.age=52;
    }
    public ConstructorOverloading(String name){
        this.name=name;
    }

    public ConstructorOverloading(int age){
        this.age=age;
    }

    public ConstructorOverloading(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void display(){
        System.out.println("Name is: "+name);
        System.out.println("Age is: "+age);
        System.out.println();
    }
}
public class P15_ConstructorOverLoading {
    public static void main(String[] args) {
        ConstructorOverloading constructorOverloading1 = new ConstructorOverloading();
        ConstructorOverloading constructorOverloading2 = new ConstructorOverloading("Ayushi");
        ConstructorOverloading constructorOverloading3 = new ConstructorOverloading(24);
        ConstructorOverloading constructorOverloading4 = new ConstructorOverloading("Harshil",21);
        constructorOverloading1.display();
        constructorOverloading2.display();
        constructorOverloading3.display();
        constructorOverloading4.display();
    }
}
