package ZSystemDesign.Behavioural;

/**
 The State Pattern is a behavioral design pattern that encapsulates state-specific behavior into
 separate classes and delegates the behavior to the appropriate state object.
 This allows the object to change its behavior without altering the underlying code.
 This pattern makes it easy to manage state transitions by isolating state-specific behavior into distinct classes.
 It helps achieve loose coupling by ensuring that each state class is independent and can evolve without affecting others.
 Real-Life Analogy:
 Consider a food delivery app. As an order progresses, its state changes through multiple stages:
 The order is placed -> The order is being prepared -> A delivery partner is assigned
 The order is picked up -> The order is out for delivery -> Finally, the order is delivered

 Trade Off:
 Adds More Classes, Slightly More Complex Initial Setup, Content Needs to Manage State Transitions, Requires Familiarity
 Uber state: Ride Requested -> Driver Assigned -> Ride Accepted -> Ride In Progress -> Ride Completed Ride Canceled
 ATM: Idle -> Card Inserted -> PIN Entered -> Transaction In Progress -> Transaction Completed -> Out of Service
 */

public class Ptn18_State {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();

        // Display initial state
        System.out.println("Current State: " + order.getCurrentState());

        // Moving through states
        order.next();  // ORDER_PLACED -> PREPARING
        order.next();  // PREPARING -> OUT_FOR_DELIVERY
        order.cancel(); // Should fail, as order is out for delivery
        order.next();  // OUT_FOR_DELIVERY -> DELIVERED
        order.cancel(); // Should fail, as order is delivered

        // Display final state
        System.out.println("Final State: " + order.getCurrentState());
    }
}

// OrderContext class manages the current state of the order
class OrderContext {
    private OrderState currentState;

    // Constructor initializes the state to ORDER_PLACED
    public OrderContext() {
        this.currentState = new OrderPlacedState(); // default state
    }

    // Method to set a new state for the order
    public void setState(OrderState state) {
        this.currentState = state;
    }

    // Method to move the order to the next state
    public void next() {
        currentState.next(this);
    }

    // Method to cancel the order
    public void cancel() {
        currentState.cancel(this);
    }

    // Method to get the current state of the order
    public String getCurrentState() {
        return currentState.getStateName();
    }
}

// OrderState interface defines the behavior of the order states
interface OrderState {
    void next(OrderContext context); // Move to the next state
    void cancel(OrderContext context); // Cancel the order
    String getStateName(); // Get the name of the state
}

// Concrete states for each stage of the order

// OrderPlacedState handles the behavior when the order is placed
class OrderPlacedState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new PreparingState());
        System.out.println("Order is now being prepared.");
    }

    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName() {
        return "ORDER_PLACED";
    }
}

// PreparingState handles the behavior when the order is being prepared
class PreparingState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new OutForDeliveryState());
        System.out.println("Order is out for delivery.");
    }

    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName() {
        return "PREPARING";
    }
}

// OutForDeliveryState handles the behavior when the order is out for delivery
class OutForDeliveryState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new DeliveredState());
        System.out.println("Order has been delivered.");
    }

    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel. Order is out for delivery.");
    }

    public String getStateName() {
        return "OUT_FOR_DELIVERY";
    }
}

// DeliveredState handles the behavior when the order is delivered
class DeliveredState implements OrderState {
    public void next(OrderContext context) {
        System.out.println("Order is already delivered.");
    }

    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel a delivered order.");
    }

    public String getStateName() {
        return "DELIVERED";
    }
}

// CancelledState handles the behavior when the order is cancelled
class CancelledState implements OrderState {
    public void next(OrderContext context) {
        System.out.println("Cancelled order cannot move to next state.");
    }

    public void cancel(OrderContext context) {
        System.out.println("Order is already cancelled.");
    }

    public String getStateName() {
        return "CANCELLED";
    }
}