package com.core;

//   Implement an interface for a real-world example, such as a payment gateway.
//  payment gateway interface
interface PaymentGateway{
    void processPayment(double amount);
    void generateReceipt(String transactionId);
}
//paypal implements of payment gateway
class Paypal implements PaymentGateway{
    private String email;

//  Constructor to initialize the mail
    public Paypal(String email){
    this.email=email;
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for account: " + email);
    }

    @Override
    public void generateReceipt(String transactionId) {
        System.out.println("PayPal Receipt: Transaction ID " + transactionId + " for account " + email);
    }
}

class CreditCard implements PaymentGateway{
    private String cardNumber;

    // Constructor to initialize card number
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " for card: " + cardNumber);
    }

    @Override
    public void generateReceipt(String transactionId) {
        System.out.println("Credit Card Receipt: Transaction ID " + transactionId + " for card " + cardNumber);
    }
}
public class P24_PaymentGateWayExample {
    public static void main(String[] args) {
//  Create a PayPal payment object
        PaymentGateway paymentGateway = new Paypal("user@example.com");
        paymentGateway.processPayment(150.00);
        paymentGateway.generateReceipt("TXN12345");
        System.out.println();

//  Create a PayPal payment object
        PaymentGateway paymentGateway1 = new CreditCard("1234-5678-9012-3456");
        paymentGateway1.processPayment(300.00);
        paymentGateway1.generateReceipt("TXN67890");
    }
}
