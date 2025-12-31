package LinkedList.HareAndTortoise;

import LinkedList.SingleLL.ListNode;

public class Q5_DeleteMiddleNode {
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        for (int i = 2; i <= 6; i++) {
            head.add(i);
        }

        System.out.println("Original List:");
        ListNode.printList(head);

        // Delete middle node
        ListNode removed = deleteMiddle(head);
        System.out.println("\nRemoved Middle Node: " + (removed != null ? removed.val : "null"));

        System.out.println("\nList After Deleting Middle:");
        ListNode.printList(head);
    }


    public static ListNode deleteMiddle(ListNode head){
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode removed = slow.next;
        slow.next = slow.next.next;
        return removed; // returning
    }
}
