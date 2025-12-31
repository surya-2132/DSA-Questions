package LinkedList.HareAndTortoise;

import LinkedList.SingleLL.ListNode;

public class Q3_LengthOfLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 2; i <= 6; i++) {
            head.add(i);
        }

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

        System.out.println("Loop length: " + lengthOfLoop(head));
    }

    public static int lengthOfLoop(ListNode head){

        if (head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                int count = 0;
                slow = slow.next;

                while(slow != fast){
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
    }
}
