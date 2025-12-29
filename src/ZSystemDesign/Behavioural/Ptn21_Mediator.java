package ZSystemDesign.Behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 The Mediator Pattern is a behavioral design pattern that centralizes complex communication between objects into a single mediation object.
 It promotes loose coupling and organizes the interaction between components.
 Instead of objects communicating directly with each other, they interact through the mediator,
 which helps simplify and manage their communication.
 Example: Flight communicating with ATC and ATC conveys this to all other flights

 Trade Off:
 Mediator Can Become Complex Over Time:
 As the system grows and more components are added, the mediator may become complex and difficult to maintain.
 The mediator can end up managing too many responsibilities, making the system harder to scale and debug.
 One Point of Failure:
 Since the mediator is responsible for handling communication between all components, it becomes a single point of failure.
 If the mediator encounters issues, it can affect the entire system, leading to potential downtime or failure in communication.
 Adds an Abstraction Layer:
 Introducing the mediator adds an extra abstraction layer, which may make the system more difficult to understand for developers
 who are unfamiliar with the pattern. While this abstraction is useful for decoupling components,
 it can also add complexity to simpler systems.
 */

public class Ptn21_Mediator {
    public static void main(String[] args) {
        CollaborativeDocument doc = new CollaborativeDocument();

        // Creating users
        User alice = new User("Alice", doc);
        User bob = new User("Bob", doc);
        User charlie = new User("Charlie", doc);

        // Joining the collaborative document
        doc.join(alice);
        doc.join(bob);
        doc.join(charlie);

        // Users making changes
        alice.makeChange("Added project title");
        bob.makeChange("Corrected grammar in paragraph 2");
    }
}


// Mediator Interface
interface DocumentSessionMediator {
    void broadcastChange(String change, User sender);
    void join(User user);
}

// Concrete Mediator Class
class CollaborativeDocument implements DocumentSessionMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void join(User user) {
        users.add(user);
    }

    @Override
    public void broadcastChange(String change, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveChange(change, sender);
            }
        }
    }
}

// User Class
class User {
    protected String name;
    protected DocumentSessionMediator mediator;

    public User(String name, DocumentSessionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    // Method for users to make a change
    public void makeChange(String change) {
        System.out.println(name + " edited the document: " + change);
        mediator.broadcastChange(change, this);
    }

    // Method to receive a change from another user
    public void receiveChange(String change, User sender) {
        System.out.println(name + " saw change from " + sender.name + ": \"" + change + "\"");
    }
}