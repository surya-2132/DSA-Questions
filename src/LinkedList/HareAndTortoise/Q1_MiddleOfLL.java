package LinkedList.HareAndTortoise;

import LinkedList.SingleLL.ListNode;

public class Q1_MiddleOfLL {

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

    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
