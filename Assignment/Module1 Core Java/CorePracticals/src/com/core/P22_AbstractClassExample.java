package com.core;

//  Create an abstract class and implement its methods in a subclass.
abstract class Payment{
    public abstract void processPayment(double amount);

    // Concrete method
    public void paymentDetails() {
        System.out.println("Processing payment securely.");
    }
}class CreditCardPayment extends Payment{
    private String cardNumber;

    // Constructor to initialize cardNumber
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card Number: " + cardNumber);
    }
}
class PayPalPayment extends Payment {
    private String email;

    // Constructor to initialize email
    public PayPalPayment(String email) {
        this.email = email;
    }

    // Implementing the abstract method
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal Account: " + email);
    }
}
public class P22_AbstractClassExample {
    public static void main(String[] args) {
        // Create objects of concrete classes
        Payment creditCardPayment = new CreditCardPayment("1234-5678-9876-5432");
        Payment paypalPayment = new PayPalPayment("user@example.com");

        // Call methods
        creditCardPayment.paymentDetails();
        creditCardPayment.processPayment(250.75);

        System.out.println();

        paypalPayment.paymentDetails();
        paypalPayment.processPayment(100.50);
    }
}
