package ZSystemDesign.Behavioural;

/**
 The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime
 by defining a set of strategies (algorithms), each encapsulated in its own class,
 and making them interchangeable via a common interface.

 It is primarily focused on changing the behavior of an object dynamically, without modifying its class.
 This promotes better organization of related algorithms and enhances code flexibility and scalability.
 Consider how Uber matches a rider with a driver. The underlying algorithm may change depending on the context,
 like matching with the nearest driver, giving priority to surge zones, or choosing from an airport queue.

 Trade Off:
 It may Lead to Too Many Small Classes: Each strategy is implemented in a separate class, which can increase code volume.
 Requires Awareness of All Strategies: The client needs to know which strategies exist and when to use each one.
 Slight Overhead Due to Interfaces: Involves extra structure around interfaces, which may be unnecessary for simple logic.
 Slightly More Complex Than if-else: For very simple cases, the Strategy Pattern may introduce more complexity than needed.
 */

public class Ptn15_Strategy {
    public static void main(String[] args) {
        // Using airport queue strategy
        RideMatchingService rideMatchingService = new RideMatchingService(new AirportQueueStrategy());
        rideMatchingService.matchRider("Terminal 1");

        // Using nearest driver strategy and later switching to surge priority
        RideMatchingService rideMatchingService2 = new RideMatchingService(new NearestDriverStrategy());
        rideMatchingService2.matchRider("Downtown");
        rideMatchingService2.setStrategy(new SurgePriorityStrategy());
        rideMatchingService2.matchRider("Downtown");
    }
}

// ==============================
// Strategy Interface
// ==============================
interface MatchingStrategy {
    void match(String riderLocation);
}

// ==============================
// Concrete Strategy: Nearest Driver
// ==============================
class NearestDriverStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching with the nearest available driver to " + riderLocation);
        // Distance-based matching logic
    }
}

// ==============================
// Concrete Strategy: Airport Queue
// ==============================
class AirportQueueStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching using FIFO airport queue for " + riderLocation);
        // Match first-in-line driver for airport pickup
    }
}

// ==============================
// Concrete Strategy: Surge Priority
// ==============================
class SurgePriorityStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching rider using surge pricing priority near " + riderLocation);
        // Prioritize high-surge zones or premium drivers
    }
}

// ==============================
// Context Class: RideMatchingService
// ==============================
class RideMatchingService {
    private MatchingStrategy strategy;

    // Constructor injection of strategy
    public RideMatchingService(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    // Setter injection for changing strategy dynamically
    public void setStrategy(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    // Delegates the matching logic to the strategy
    public void matchRider(String location) {
        strategy.match(location);
    }
}
