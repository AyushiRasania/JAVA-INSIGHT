package com.core;

//   Write a program to create and run multiple threads using the Thread class.
class MyThread extends Thread{

    private String threadName;

    // Constructor to set thread name
    public MyThread(String name) {
        this.threadName = name;
    }

    // Override the run() method to define the thread's task
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running: Step " + i);
            try {
                // Sleep for a while to simulate work
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
}
public class P30_MultiThreadExample {
    public static void main(String[] args) {
        // Create multiple threads
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        MyThread thread3 = new MyThread("Thread-3");

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Main thread message
        System.out.println("Main thread is running independently.");
    }
}
