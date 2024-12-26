package StackAndQueue.Implementations;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue = new LinkedList<>();

    public StackUsingQueue(){}

    public void push(int num){
        queue.add(num);
        // Move elements before the new element to back
        for(int i = 0; i < queue.size(); i++){
            queue.add(queue.poll());
        }
    }

    public int poll(){
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        int elem = queue.peek();
        queue.poll();
        return elem;
    }

    public int peek(){
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue.peek();
    }
}
