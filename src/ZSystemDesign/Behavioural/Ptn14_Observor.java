package ZSystemDesign.Behavioural;

import java.util.ArrayList;
import java.util.List;


/**
 The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects
 so that when one object (the subject) changes its state, all its dependents (called observers) are notified and updated automatically.
 The Observer Pattern is a behavioral design pattern where an object, known as the subject,
 maintains a list of dependents (observers) and notifies them of any state changes, usually by calling one of their methods.
 This means if multiple objects are watching another object for updates, they don’t need to keep checking repeatedly.
 Instead, they get notified as soon as something changes — making the system more efficient and loosely coupled

 Trade Off:
 Unpredictable Update Sequences: If the order of observer notifications matters, it may be hard to manage as the pattern does not guarantee update order.
 Performance Bottlenecks at Scale: Notifying a large number of observers synchronously can degrade performance in high-scale systems.
 Risk of Memory Leaks: Failure to unsubscribe unused observers may result in lingering references and memory issues.
 Difficult Debugging: Since interactions happen indirectly through interfaces, tracing the source of bugs or unwanted updates can be challenging.
 Tight Timing Coupling: All observers are notified immediately. Delayed or controlled delivery of events is not supported natively.
 */

public class Ptn14_Observor {
    public static void main(String[] args) {
        YouTubeChannel tuf = new YouTubeChannel("takeUforward");

        // Add subscribers
        tuf.subscribe(new MobileAppSubscriber("raj"));
        tuf.subscribe(new EmailSubscriber("rahul@example.com"));

        // Upload video and notify all observers
        tuf.uploadVideo("observer-pattern");
    }
}

// ==============================
// Observer Interface
// ==============================
interface Subscriber {
    void update(String videoTitle);
}

// ==============================
// Concrete Observer: Email
// ==============================
class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Email sent to " + email + ": New video uploaded - " + videoTitle);
    }
}

// ==============================
// Concrete Observer: Mobile App
// ==============================
class MobileAppSubscriber implements Subscriber {
    private String username;

    public MobileAppSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("In-app notification for " + username + ": New video - " + videoTitle);
    }
}

// ==============================
// Subject Interface
// ==============================
interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}

// ==============================
// Concrete Subject: YouTubeChannel
// ==============================
class YouTubeChannel implements Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

    // Simulates video upload and triggers notifications
    public void uploadVideo(String videoTitle) {
        System.out.println(channelName + " uploaded: " + videoTitle + "\n");
        notifySubscribers(videoTitle);
    }
}