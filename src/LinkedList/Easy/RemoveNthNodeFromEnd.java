package LinkedList.Easy;

import LinkedList.SingleLL.ListNode;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthNodeBrute(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = head;
        if (count == n) {
            return temp.next;
        }

        while (count > 0) {
            temp = temp.next;
            count--;
        }

        temp.next = temp.next.next;

        return head;
    }


    public static ListNode removeNthNodeOptimal(ListNode head, int n) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}