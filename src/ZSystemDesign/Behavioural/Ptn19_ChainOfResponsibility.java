package ZSystemDesign.Behavioural;

/**
 Imagine you're working in a customer support system. A customer submits a request that can be handled by multiple support teams,
 such as basic inquiries, technical issues, or billing problems. The Chain of Responsibility Pattern allows the system
 to forward the request through a chain of support teams (handlers), with each team deciding if they can resolve the issue
 or pass it along to the next team. This ensures that each team handles only the requests they are best suited to process,
 and the customer remains unaware of the chain of responsibility.
 How It Works:
 The client sends a request to the first handler in the chain. If that handler can process the request, it does so.
 If not, it forwards the request to the next handler. This continues until either the request is handled or the end of the chain is reached.
 The pattern allows for flexibility by enabling new handlers to be added to the chain without altering existing code.
 Let's now understand the working of the Chain of Responsibility Pattern through a problem statement

 Trade Off:
 May lead to performance issues if the chain is too long:
 Debugging can be harder due to the dynamic flow of the chain:
 Risk of request not being handled at all:
 Sequence is important, as the order can break the logic:
 */

public class Ptn19_ChainOfResponsibility {
    public static void main(String[] args) {
        SupportHandler general = new GeneralSupport();
        SupportHandler billing = new BillingSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler delivery = new DeliverySupport();

        // Setting up the chain: general -> billing -> technical -> delivery
        general.setNextHandler(billing);
        billing.setNextHandler(technical);
        technical.setNextHandler(delivery);

        // Testing the chain of responsibility with different request types
        general.handleRequest("refund");
        general.handleRequest("delivery");
        general.handleRequest("unknown");
    }
}



// Abstract class defining the SupportHandler
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    // Method to set the next handler in the chain
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Abstract method to handle the request
    public abstract void handleRequest(String requestType);
}

// Concrete Handler for General Support
class GeneralSupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("general")) {
            System.out.println("GeneralSupport: Handling general query");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
    }
}

// Concrete Handler for Billing Support
class BillingSupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("refund")) {
            System.out.println("BillingSupport: Handling refund request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
    }
}

// Concrete Handler for Technical Support
class TechnicalSupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("technical")) {
            System.out.println("TechnicalSupport: Handling technical issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
    }
}

// Concrete Handler for Delivery Support
class DeliverySupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("delivery")) {
            System.out.println("DeliverySupport: Handling delivery issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        } else {
            System.out.println("DeliverySupport: No handler found for request");
        }
    }
}