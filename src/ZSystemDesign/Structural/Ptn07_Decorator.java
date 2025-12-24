package ZSystemDesign.Structural;

    /**
      The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects,
     dynamically at runtime, without affecting the behavior of other objects from the same class.

      It wraps an object inside another object that adds new behaviors or responsibilities at runtime,
     keeping the original object's interface intact.

     Trade Off:

     Avoids Class Explosion: You no longer need a separate class for each combination of toppings. Just create new decorators as needed.
     Flexible & Scalable: Toppings can be added, removed, or reordered at runtime, offering high customization.
     Follows Open/Closed Principle: The base Pizza classes are open for extension (via decorators) but closed for modification.
     Cleaner Code Architecture: Composition is used instead of inheritance, resulting in loosely coupled components.
     Promotes Reusability: Each topping is a self-contained decorator and can be reused across different pizza compositions.
     */

public class Ptn07_Decorator {

    public static void main(String[] args) {
        // Start with a basic Margherita Pizza
        Pizza myPizza = new MargheritaPizza();

        // Add Extra Cheese
        myPizza = new ExtraCheese(myPizza);

        // Add Olives
        myPizza = new Olives(myPizza);

        // Add Stuffed Crust
        myPizza = new StuffedCrust(myPizza);

        // Final Description and Cost
        System.out.println("Pizza Description: " + myPizza.getDescription());
        System.out.println("Total Cost: ₹" + myPizza.getCost());
    }
}


// =========== Component Interface ============
interface Pizza {
    String getDescription();
    double getCost();
}

// ============= Concrete Components: Base pizza ==============
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 150.00;
    }
}

class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }
}


// ======================== Abstract Decorator ===========================
// ====== Implements Pizza and holds a reference to a Pizza object =======
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// ============ Concrete Decorator: Adds Extra Cheese ================
class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40.0;
    }
}

// ============ Concrete Decorator: Adds Olives ================
class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}

// =========== Concrete Decorator: Adds Stuffed Crust Cheese ==============
class StuffedCrust extends PizzaDecorator {
    public StuffedCrust(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Stuffed Crust";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}