package StackAndQueue.Implementations;

public class StackUsingArray {

    private final int[] stackArray;  // Array to hold elements

    private final int capacity; // Maximum capacity

    private int topIndex;  // Index of the top element

    // Constructor
    public StackUsingArray(int size) {
        this.capacity = size;
        stackArray = new int[this.capacity]; // Initialize stack as empty
        topIndex = -1;
    }

    public StackUsingArray() {
        this(1000);
    }

    // Pushes element x 
    public void push(int x) {
        if (topIndex >= capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++topIndex] = x;
    }

    // Removes and returns the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            // Return invalid value
            return -1;
        }
        return stackArray[topIndex--];
    }

    // Returns top element
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex];
    }

    // Returns true if the stack is empty, false otherwise */
    public boolean isEmpty() {
        return topIndex == -1;
    }
}