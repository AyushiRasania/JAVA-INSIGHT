package com.core;

//   Write a program that demonstrates inheritance using extends keyword.
class Person{
    String name;
    int age;
    public void displayInfo(){
        System.out.println("Name is: "+name);
        System.out.println("Age is: "+age);
    }
}
class Student1 extends Person{
    String course;
    public void study(){
        System.out.println(name+" is studying "+course);
    }
}
class Teacher extends Person{
    String subject;
    public void teach(){
        System.out.println(name+" is teaching "+subject);
    }
}
public class P19_InheritanceExample {
    public static void main(String[] args) {
        // Create an object of Student
        Student1 student1 = new Student1();
        student1.name="Ayushi";
        student1.age=24;
        student1.course="Java";
        student1.displayInfo();
        student1.study();
        System.out.println();

        // Create an object of Teacher
        Teacher teacher = new Teacher();
        teacher.name="Asha";
        teacher.age=52;
        teacher.subject="science";
        teacher.displayInfo();
        teacher.teach();
    }
}
