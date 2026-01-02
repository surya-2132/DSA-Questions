package LinkedList.Essential;

import LinkedList.SingleLL.ListNode;

public class Q0_FindMiddle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        for (int i = 2; i <= 6; i++) {
            head.add(i);
        }

        ListNode.printList(head);

        // Find and print middle
        ListNode middle = findMiddle(head);
        System.out.println("Middle node value: " + middle.val);
        System.out.println("Middle onwards: " + middle);
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next; // head.next because out of 2 middles m1 and m2 we need m1 particularly.

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
