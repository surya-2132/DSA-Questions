package LinkedList.Essential.HareAndTortoise;

import LinkedList.SingleLL.ListNode;

public class Q2_DetectLoopOfLL {

    public static void main(String[] args) {

        // ---------- Case 1: No loop ----------
        ListNode head = new ListNode(1);
        for (int i = 2; i <= 6; i++) {
            head.add(i);
        }
        System.out.println("Loop present (no loop case): " + detectLoop(head));

        // ---------- Case 2: Create a loop ----------
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //           ^--------------|
        ListNode temp = head;
        ListNode loopNode = null;
        while (temp.next != null) {
            if (temp.val == 3) {
                loopNode = temp;
            }
            temp = temp.next;
        }
        temp.next = loopNode;  // connect last node to node with value 3

        System.out.println("Loop present (loop case): " + detectLoop(head));
    }

    public static boolean detectLoop(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}
