package StackAndQueue.Implementations;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack1, stack2;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int num){
        stack1.push(num);
    }

    public int pop(){

        // Check if both stacks are empty (edge case)
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Representing empty queue
        }

        if(stack2.isEmpty()){
            while(!stack1.empty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }

        int num = stack2.peek();
        stack2.pop();
        return num;
    }

    public int peek(){
        // Check if both stacks are empty (edge case)
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Representing empty queue
        }

        if(stack2.isEmpty()){
            while(!stack1.empty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }

        return stack2.peek();
    }
}
