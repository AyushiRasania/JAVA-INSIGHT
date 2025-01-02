package com.core;

//    Create a classwithstatic variables and methods to demonstrate their use.
class StaticTest {

    //    creating a static variable
    static int count = 0;

    //    creating an instance variable
    int instanceVariable;

    //    creating default constructor
    public StaticTest() {
        count++;
        instanceVariable++;
    }

    public static int getCount() {
        return count;
    }

    public int getInstanceVariable() {
        return instanceVariable;
    }
}

public class P10_StaticExample {
    public static void main(String[] args) {
        StaticTest staticTest1 = new StaticTest();
        StaticTest staticTest2 = new StaticTest();

        System.out.println("static variable(counter): " + StaticTest.getCount());
        System.out.println("Instance variable of object 1: " + staticTest1.getInstanceVariable());
        System.out.println("Instance variable of object 2: " + staticTest2.getInstanceVariable());
    }
}
