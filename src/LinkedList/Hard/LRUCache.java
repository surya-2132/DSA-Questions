package LinkedList.Hard;

import java.util.HashMap;


// Creating DLL with:
// i)  key, val for insertion
// ii) prev and next for node reference
class Node{
    public int key;
    public int val;
    Node prev;
    Node next;

    Node(){
        key = -1;
        val = -1;
        next = null;
        prev = null;
    }

    Node (int key, int val){
        this.key = key;
        this.val = val;
        next = prev = null;
    }
}


public class LRUCache {
    // required variables
    private final int capacity;
    private final Node head;
    private final Node tail;
    private final HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize head and tail as dummy nodes for easy manipulation
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }



    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        //once we touch the node, it should go next to head to maintain LRU
        //it became recently active so move next to head;
        //Delete REFERENCE (not node itself) and link next to head;
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //if the node exists, then just change the value
            //since we touched it REASSIGN REFERENCE to headNext
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            // If the cache is at max capacity, remove the LRU3 node (before tail)
            if(map.size() == capacity){
                Node lruNode = tail.prev;
                deleteNode(lruNode);
                map.remove(lruNode.key);
            }

            // create node, put it in the map, insert next to head
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);
        }

    }


    public void deleteNode(Node node){
        // Unlink the node from the list
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    public void insertAfterHead(Node node){
        // Insert the node after the head (most recently used)
        Node currHeadNext = head.next;
        head.next = node;
        node.next = currHeadNext;
        node.prev = head;
        currHeadNext.prev = node;
    }
}