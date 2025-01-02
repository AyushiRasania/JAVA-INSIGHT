package com.core;

// Use the super keyword to call the parent class constructor and methods.
class Person1{
    String name;
    int age;

    public Person1(String name, int age){
        this.name=name;
        this.age=age;
        System.out.println("Person constructor called");
    }

    public void information(){
        System.out.println("Name is: "+name);
        System.out.println("Age is: "+age);
    }
}
class Employee extends Person1{
    String department;
    public Employee(String name, int age, String department) {
        super(name, age);
        this.department=department;
        System.out.println("Employee constructor called");
    }

    @Override
    public void information() {
        super.information();
        System.out.println("Department is: "+department);
    }
}
class Manager extends Employee{
int teamSize;
    public Manager(String name, int age, String department,int teamSize) {
        super(name, age, department);
        this.teamSize=teamSize;
        System.out.println("Manager constructor is called");
    }

    @Override
    public void information() {
        super.information();
        System.out.println("Team size is: "+teamSize);
    }
}
public class P21_SuperKeywordExample {
    public static void main(String[] args) {
        Manager manager =new Manager("Aesha", 35, "IT", 10);
        manager.information();
    }
}
