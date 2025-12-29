package ZSystemDesign.Behavioural;

/**
 The Template Pattern is a behavioral design pattern that provides a blueprint for executing an algorithm.
 It allows subclasses to override specific steps of the algorithm, but the overall structure remains the same.
 This ensures that the invariant parts of the algorithm are not changed, while enabling customization in the variable parts.
 Imagine, you are following a recipe to bake a cake. The overall process of baking a cake (preheat oven,
 mix ingredients, bake, and cool) is fixed, but the specific ingredients or flavors may vary (chocolate, vanilla, etc.).
 The Template Pattern is like the recipe: it defines the basic structure of the process (steps),
 while allowing the specific ingredients (or steps) to be varied depending on the cake type.

 Trade Off:
 Inheritance-based, limits flexibility: The Template Pattern uses inheritance, which can reduce flexibility as the behavior is tightly coupled with the base class.
 Subclasses are tightly coupled with the base class: Any changes in the base class may affect all subclasses, making it harder to modify or extend certain features independently.
 Not ideal if the algorithm varies, switch to Strategy Pattern: If the algorithm changes significantly, the Template Pattern becomes less suitable, and using the Strategy Pattern may be a better choice.
 May result in too many subclasses: If the number of steps to be customized grows, you might end up creating too many subclasses, making the codebase harder to maintain.
 */

public class Ptn17_Template {
    public static void main(String[] args) {
        NotificationSender emailSender = new EmailNotification();
        emailSender.send("john@example.com", "Welcome to TUF+!");

        System.out.println(" ");

        NotificationSender smsSender = new SMSNotification();
        smsSender.send("9876543210", "Your OTP is 4567.");
    }
}


// Abstract class defining the template method and common steps
abstract class NotificationSender {

    // Template method
    public final void send(String to, String rawMessage) {
        // Common Logic
        rateLimitCheck(to);
        validateRecipient(to);
        String formatted = formatMessage(rawMessage);
        preSendAuditLog(to, formatted);

        // Specific Logic: defined by subclasses
        String composedMessage = composeMessage(formatted);
        sendMessage(to, composedMessage);

        // Optional Hook
        postSendAnalytics(to);
    }

    // Common step 1: Check rate limits
    private void rateLimitCheck(String to) {
        System.out.println("Checking rate limits for: " + to);
    }

    // Common step 2: Validate recipient
    private void validateRecipient(String to) {
        System.out.println("Validating recipient: " + to);
    }

    // Common step 3: Format the message (can be customized)
    private String formatMessage(String message) {
        return message.trim(); // could include HTML escaping, emoji processing, etc.
    }

    // Common step 4: Pre-send audit log
    private void preSendAuditLog(String to, String formatted) {
        System.out.println("Logging before send: " + formatted + " to " + to);
    }

    // Hook for subclasses to implement custom message composition
    protected abstract String composeMessage(String formattedMessage);

    // Hook for subclasses to implement custom message sending
    protected abstract void sendMessage(String to, String message);

    // Optional hook for analytics (can be overridden)
    protected void postSendAnalytics(String to) {
        System.out.println("Analytics updated for: " + to);
    }
}

// Concrete class for email notifications
class EmailNotification extends NotificationSender {

    // Implement message composition for email
    @Override
    protected String composeMessage(String formattedMessage) {
        return "<html><body><p>" + formattedMessage + "</p></body></html>";
    }

    // Implement email sending logic
    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending EMAIL to " + to + " with content:\n" + message);
    }
}

// Concrete class for SMS notifications
class SMSNotification extends NotificationSender {

    // Implement message composition for SMS
    @Override
    protected String composeMessage(String formattedMessage) {
        return "[SMS] " + formattedMessage;
    }

    // Implement SMS sending logic
    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending SMS to " + to + " with message: " + message);
    }

    // Override optional hook for custom SMS analytics
    @Override
    protected void postSendAnalytics(String to) {
        System.out.println("Custom SMS analytics for: " + to);
    }
}