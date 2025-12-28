package LinkedList.SingleLL;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode(int data, ListNode next) {
        this.val = data;
    }


    // Method to add a node at the end of the list
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        ListNode temp = this;

        // Traverse to the end of the list
        while (temp.next != null) {
            temp = temp.next;
        }

        // Add the new node
        temp.next = newNode;
    }


    // Method to add a node at the end of the list
    public void delete(ListNode head) {

        if(head == null || head.next == null){
            head = null;
            System.out.println("No head is present || cant perform operation on empty list");
            return;
        }

        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Add the new node
        temp.next = null;
    }



    // Print method for Single Linked List
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        ListNode temp = head;
        System.out.print("Single Linked List: ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(" -> ");
            curr = curr.next;
        }
        return sb.toString();
    }
}
