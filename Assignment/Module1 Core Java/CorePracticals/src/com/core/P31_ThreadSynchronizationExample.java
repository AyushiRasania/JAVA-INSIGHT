package com.core;
// Implement thread synchronization using synchronized blocks or methods.
// Shared resource class
class SharedCounter {
    private int counter = 0;

    // Synchronized method to increment the counter
    public synchronized void increment(String threadName) {
        counter++;
        System.out.println(threadName + " incremented counter to: " + counter);
    }

    // Getter for the counter
    public int getCounter() {
        return counter;
    }
}

// Custom thread class
class CounterThread extends Thread {
    private SharedCounter sharedCounter;

    // Constructor to initialize shared resource
    public CounterThread(SharedCounter sharedCounter, String threadName) {
        super(threadName);
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedCounter.increment(Thread.currentThread().getName());
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
    }
}

public class P31_ThreadSynchronizationExample {
    public static void main(String[] args) {
        // Create a shared counter object
        SharedCounter sharedCounter = new SharedCounter();

        // Create multiple threads sharing the same counter
        Thread thread1 = new CounterThread(sharedCounter, "Thread-1");
        Thread thread2 = new CounterThread(sharedCounter, "Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Final counter value
        System.out.println("Final counter value: " + sharedCounter.getCounter());
    }
}
