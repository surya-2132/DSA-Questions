package ZSystemDesign.Structural;
    /**
     The Facade Pattern is a structural design pattern that provides a simplified,
     unified interface to a complex subsystem or group of classes.

     It acts as a single entry point for clients to interact with the system,
     hiding the underlying complexity and making the system easier to use.

     Trade Off:

     Fragile coupling: If the facade itself changes frequently, it can still lead to ripple effects on client code.
     Hidden complexity: While it simplifies the client's view, the underlying complexity of the subsystem still exists, just hidden.
            This can make debugging or understanding the full flow more challenging for developers working on the subsystem.
     Runtime errors: Errors originating from the complex subsystem might be harder to diagnose when only interacting through the facade.
     Difficult to trace: Debugging can be more challenging as the facade adds another layer of indirection.
     Violation of SRP (Single Responsibility Principle): A facade might take on too many responsibilities
            if it orchestrates a very large and diverse set of operations, potentially becoming a "god object."
     **/

public class Ptn08_Facade {
    public static void main(String[] args) {
        // Booking a movie ticket manually (using facade)
        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();
        movieBookingFacade.bookMovieTicket("user123", "movie456",
                "A10", "user@example.com", 500);
    }
}



// Service class responsible for handling payments
class PaymentService {
    public void makePayment(String accountId, double amount) {
        System.out.println("Payment of ₹" + amount + " successful for account " + accountId);
    }
}

// Service class responsible for reserving seats
class SeatReservationService {
    public void reserveSeat(String movieId, String seatNumber) {
        System.out.println("Seat " + seatNumber + " reserved for movie " + movieId);
    }
}

// Service class responsible for sending notifications
class NotificationService {
    public void sendBookingConfirmation(String userEmail) {
        System.out.println("Booking confirmation sent to " + userEmail);
    }
}

// Service class for managing loyalty/reward points
class LoyaltyPointsService {
    public void addPoints(String accountId, int points) {
        System.out.println(points + " loyalty points added to account " + accountId);
    }
}

// Service class for generating movie tickets
class TicketService {
    public void generateTicket(String movieId, String seatNumber) {
        System.out.println("Ticket generated for movie " + movieId + ", Seat: " + seatNumber);
    }
}


// ========== The MovieBookingFacade class  ==============
class MovieBookingFacade {
    private PaymentService paymentService;
    private SeatReservationService seatReservationService;
    private NotificationService notificationService;
    private LoyaltyPointsService loyaltyPointsService;
    private TicketService ticketService;

    // Constructor to initialize all the subsystem services.
    public MovieBookingFacade() {
        this.paymentService = new PaymentService();
        this.seatReservationService = new SeatReservationService();
        this.notificationService = new NotificationService();
        this.loyaltyPointsService = new LoyaltyPointsService();
        this.ticketService = new TicketService();
    }

    // Method providing a simplified interface for booking a movie ticket
    public void bookMovieTicket(String accountId, String movieId, String seatNumber, String userEmail, double amount){
        paymentService.makePayment(accountId, amount);
        seatReservationService.reserveSeat(movieId, seatNumber);
        ticketService.generateTicket(movieId, seatNumber);
        loyaltyPointsService.addPoints(accountId, 50);
        notificationService.sendBookingConfirmation(userEmail);

        // Indicate successful completion of the entire booking process.
        System.out.println("Movie ticket booking completed successfully!");
    }
}