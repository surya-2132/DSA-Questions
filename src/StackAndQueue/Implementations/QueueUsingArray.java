package StackAndQueue.Implementations;

public class QueueUsingArray {
    // Required variables
    private final int[] queue;
    private final int maxSize;
    private int currSize;
    private int start;
    private int end;

    // Initialization constructor with values
    public QueueUsingArray(int size) {
        this.maxSize = size;
        queue = new int[maxSize];
        start = -1;
        end = -1;
    }

    // default constructor with queue size
    public QueueUsingArray(){
        this(1000);
    }


    public void push(int x) {
        // if queue is full
        if(currSize == maxSize){
            System.out.print("Queue is full");
            return;
        }

        // if queue is empty move s and e to 0th index
        if(currSize == 0){
            start = 0;
            end = 0;
        }
        // when we just need to add elem in queue, just do it
        else{
            end = (end + 1) % maxSize; //circular arr formula to move end
        }

        queue[end] = x;
        currSize++;
    }

    public int pop() {
        //if queue ie empty
        if(currSize == 0){
            System.out.print("Queue is empty");
            return -1;
        }

        //if we have only one elem in queue, store curr elem
        //reset curr index and return that elem
        int elem = queue[start];
        if(currSize == 1){
            start = -1;
            end = -1;
        }
        else{
            start = (start + 1)  % maxSize; //shrink arry size
        }
        currSize--;
        return elem;
    }

    public int peek() {
        //if queue ie empty
        if(currSize == 0){
            System.out.print("Queue is empty");
            return -1;
        }

        //else return current first elem
        return queue[start];
    }

    public boolean isEmpty() {
        return (currSize == 0);
    }

    public int size(){
        return currSize;
    }
}
