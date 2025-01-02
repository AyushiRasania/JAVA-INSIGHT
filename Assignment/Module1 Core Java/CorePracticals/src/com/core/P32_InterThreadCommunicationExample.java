package com.core;
// Use inter-thread communication methods like wait(), notify(), and
// notifyAll().
// Shared resource class
class SharedBuffer {
    private int data;
    private boolean hasData = false;

    // Synchronized method to produce data
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // Wait until the consumer consumes the data
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify(); // Notify the consumer
    }

    // Synchronized method to consume data
    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait(); // Wait until the producer produces data
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // Notify the producer
    }
}

// Producer thread class
class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i); // Produce data
                Thread.sleep(500); // Simulate delay
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted.");
        }
    }
}

// Consumer thread class
class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume(); // Consume data
                Thread.sleep(1000); // Simulate delay
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
        }
    }
}
public class P32_InterThreadCommunicationExample {
    public static void main(String[] args) {
        // Create a shared buffer
        SharedBuffer buffer = new SharedBuffer();

        // Create producer and consumer threads
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Start the threads
        producer.start();
        consumer.start();
    }
}
