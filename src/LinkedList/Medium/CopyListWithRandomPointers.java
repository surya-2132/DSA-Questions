package LinkedList.Medium;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode() {
        val = 0;
        next = null;
        random = null;
    }

    ListNode(int val) {
        this.val = val;
        next = null;
        random = null;
    }

    ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

public class CopyListWithRandomPointers {

    public ListNode copyRandomList(ListNode head) {
        // Step 1: Create a map to store the original node and its copy
        if(head == null){
            return null;
        }

        Map<ListNode, ListNode> orgCopyMap = new HashMap<>();
        ListNode temp = head;

        // Make a copy of each node and store the map's entry as original and its copy
        while(temp != null){
            ListNode newNode = new ListNode(temp.val); //creating copy of each node of org node on each iteration.
            orgCopyMap.put(temp, newNode); //entry of org node as key and copy node as value
            temp = temp.next;
        }


        //Step 2: link the pointer, first link original then link random for each node on each iteration
        //First - Set next ptr of copied node to the copied node of the next original node
        //Second - Set the random ptr of the copied node to the copied node of the random original node
        temp = head;
        while(temp != null){
            ListNode copyNode = orgCopyMap.get(temp); // Get the copied node from the map
            copyNode.next = orgCopyMap.get(temp.next); // Link the copied node's 'next' pointer
            copyNode.random = orgCopyMap.get(temp.random); // Link the copied node's 'random' pointer
            temp = temp.next; // Move to the next node
        }

        return orgCopyMap.get(head);
    }


    // Function to print the linked list
    public static void printClonedLinkedList(ListNode head) {
        while (head != null) {
            // Print the data of the current node
            System.out.print("Data: " + head.val);
            // Print the data of the random pointer, if it exists
            if (head.random != null) {
                System.out.print(", Random: " + head.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            // Move to the next node
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        ListNode head = new ListNode(7);
        head.next = new ListNode(14);
        head.next.next = new ListNode(21);
        head.next.next.next = new ListNode(28);

        // Assigning random pointers
        head.random = head.next.next; // 7 -> 21
        head.next.random = head; // 14 -> 7
        head.next.next.random = head.next.next.next; // 21 -> 28
        head.next.next.next.random = head.next; // 28 -> 14

        // Print the original linked list
        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        // Clone the linked list
        CopyListWithRandomPointers solution = new CopyListWithRandomPointers();
        ListNode clonedList = solution.copyRandomList(head);

        // Print the cloned linked list
        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);

    }
}
