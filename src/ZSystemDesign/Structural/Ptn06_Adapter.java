package ZSystemDesign.Structural;

import java.util.*;
    /**
    The Adapter Pattern allows incompatible interfaces to work together by acting as a
    translator or wrapper around an existing class. It converts the interface of a class
     into another interface that a client expects.

    It acts as a bridge between the Target interface (expected by the client)
    and the Adaptee (an existing class with a different interface).
    This structural wrapping enables integration and compatibility across diverse systems.

     Trade Off:
     Adds an Extra Layer of Abstraction: Can introduce unnecessary complexity if not used judiciously.
     Overuse Can Obscure System Design: Excessive use of adapters
     might make the architecture harder to understand and maintain.

     **/
public class Ptn06_Adapter {
    public static void main(String[] args) {
        // Using PayU payment gateway to process payment
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.checkout("12", 1780);
    }
}


// Target Interface: 
// Standard interface expected by the CheckoutService
interface PaymentGateway {
    void pay(String orderId, double amount);
}



// Concrete implementation of PaymentGateway for PayU
class PayUGateway implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paid Rs. " + amount + " using PayU for order: " + orderId);
    }
}



// Adapter:
// An existing class with an incompatible interface
class RazorpayAPI {
    public void makePayment(String invoiceId, double amountInRupees) {
        System.out.println("Paid Rs. " + amountInRupees + " using Razorpay for invoice: " + invoiceId);
    }
}



// Client Class:
// Uses PaymentGateway interface to process payments
class CheckoutService {
    private PaymentGateway paymentGateway;

    // Constructor injection for dependency inversion
    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Business logic to perform checkout
    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}