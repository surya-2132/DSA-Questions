package StackAndQueue.FAQs;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;
    public MinStack() {}


    public static void main(String[] args) {
        MinStack minStack = new MinStack();  // Create an instance of MinStack

        minStack.push(10);  // Call instance methods
        minStack.push(9);
        minStack.push(11);
        minStack.pop();
        minStack.top();
        minStack.pop();
        minStack.pop();

        System.out.println("Top element: " + minStack.top());
        System.out.println("Minimum element: " + minStack.getMin());
    }


    // Push the value into stack, update min if necessary
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            min = val;  // Set min for the first value
        } else {
            if(val < min){
                stack.push(2 * val - min);  // Encode previous min into stack
                min = val;  // Update min
            } else {
                stack.push(val);  // Regular push if val > min
            }
        }
    }

    // Pop the top value, update min if necessary
    public void pop() {
        if(stack.isEmpty()) return;

        int peekVal = stack.peek();
        stack.pop();

        if(peekVal < min){  // Update min when the popped value was the encoded one
            min = 2 * min - peekVal;
        }
    }

    // Return the top value, check if min should be returned
    public int top() {
        if(stack.isEmpty()) return -1;

        int peekVal = stack.peek();
        return (min < peekVal) ? peekVal : min;  // If encoded, return min
    }

    // Return the current minimum value
    public int getMin() {
        return min;
    }
}
