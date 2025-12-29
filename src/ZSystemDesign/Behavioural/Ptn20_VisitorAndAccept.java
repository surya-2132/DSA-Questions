package ZSystemDesign.Behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 The Visitor Pattern is a behavioral design pattern that lets you add new operations
 to existing class hierarchies without modifying the classes themselves. This is achieved by moving
 the logic of the operation into a separate class, known as the "visitor".
 The main advantage of the Visitor Pattern is that it allows you to decouple operations from the objects on which they operate,
 enabling you to add new operations without changing the classes that contain the objects.
 This promotes Open-Closed Principle (OCP), as new functionality can be added without modifying existing code.

 Real-Life Analogy:
 Imagine a shopping mall where various shops sell different kinds of products. Each shop (element) has a unique way of applying a discount (operation).
 Rather than having each shop implement its own method for calculating discounts, we create a discount visitor that visits each shop
 and applies the appropriate discount logic. This way, we can easily add new types of discounts in the future
 without changing the shop classes.

 Trade Off:
 Adding New Elements Requires Modifying the Visitor Interface:
 Can Be an Overkill for Simple Object Structures:
 Double Dispatch Might Be Unintuitive for Some:
 Element and Visitor Classes are Tightly Coupled:

 Required Players: ItemElement, ItemVisitor, ConcreteElement(They define products), ConcreteVisitor (They do operations),
 */

public class Ptn20_VisitorAndAccept {
    public static void main(String[] args) {
        List<ItemElement> itemElements = new ArrayList<>();
        itemElements.add(new PhysicalProduct("Shoes", 1.2));
        itemElements.add(new DigitalProduct("Ebook", 100));
        itemElements.add(new GiftCard("TUF500", 500));

        ItemVisitor invoiceGenerator = new InvoiceVisitor();
        ItemVisitor shippingCalculator = new ShippingCostVisitor();

        for (ItemElement itemElement : itemElements) {
            itemElement.accept(invoiceGenerator);
            itemElement.accept(shippingCalculator);

            System.out.println(" ");
        }
    }
}


// ======= Element Interface ==========
interface ItemElement {
    void accept(ItemVisitor visitor);
}


// ======== Visitor Interface ============
interface ItemVisitor {
    void visit(PhysicalProduct item);
    void visit(DigitalProduct item);
    void visit(GiftCard item);
}


// ======= Concrete elements ===========
class PhysicalProduct implements ItemElement {
    String name;
    double weight;

    public PhysicalProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);  //which item visitor type
    }
}

// ======= Concrete elements ===========
class DigitalProduct implements ItemElement {
    String name;
    int downloadSizeInMB;

    public DigitalProduct(String name, int downloadSizeInMB) {
        this.name = name;
        this.downloadSizeInMB = downloadSizeInMB;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);//this is current object instance
    }
}

// ======= Concrete elements ===========
class GiftCard implements ItemElement {
    String code;
    double amount;

    public GiftCard(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}


// ============ Concrete Visitors ==============
class InvoiceVisitor implements ItemVisitor {
    public void visit(PhysicalProduct item) {
        System.out.println("Invoice: " + item.name + " - Shipping to customer");
    }

    public void visit(DigitalProduct item) {
        System.out.println("Invoice: " + item.name + " - Email with download link");
    }

    public void visit(GiftCard item) {
        System.out.println("Invoice: Gift Card - Code: " + item.code);
    }
}

// ============ Concrete Visitors ==============
class ShippingCostVisitor implements ItemVisitor {
    public void visit(PhysicalProduct item) {
        System.out.println("Shipping cost for " + item.name + ": Rs. " + (item.weight * 10));
    }

    public void visit(DigitalProduct item) {
        System.out.println(item.name + " is digital -- No shipping cost.");
    }

    public void visit(GiftCard item) {
        System.out.println("GiftCard delivery via email -- No shipping cost.");
    }
}