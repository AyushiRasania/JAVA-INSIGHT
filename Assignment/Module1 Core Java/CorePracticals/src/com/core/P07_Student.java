package com.core;

// CreateaclassStudent withattributes (name, age) and a method to display the details.
// Createmultiple constructors in a class and demonstrate constructor overloading.
// Implementasimpleclass with getters and setters for encapsulation.
 class Student {
// Attribute
    String name;
    int age;

//     Constructor Overloading
//    Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;

    }

    //    one parameterized constructor
    public Student(String name) {
        this.name = name;
    }

    //    two parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    Getter and setter for Encapsulation
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

//    Method to display student details
    public void studentDetails(){
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
    }

}
public class P07_Student{
    public static void main(String[] args) {
//        using default constructor
        Student student1 = new Student();
        System.out.println("Student1 details: ");
        student1.studentDetails();
        System.out.println();

//        using one parameterized constructor
        Student student2 = new Student("Ayushi");
        System.out.println("Student2 details:");
        student2.studentDetails();
        System.out.println();

//        using two parameterized constructor
        Student student3 = new Student("Harshil",21);
        System.out.println("Student3 details:");
        student3.studentDetails();
        System.out.println();

//         Using setters to update details
        student1.setName("yesha");
        student1.setAge(10);
        System.out.println("Updated Student 1 details");
        student1.studentDetails();
        System.out.println();

//        using getter
        System.out.println("Using getter");
        System.out.println("Student 3 name : "+student3.getName());
        System.out.println("Student 3 age : "+student3.getAge());
    }
}
