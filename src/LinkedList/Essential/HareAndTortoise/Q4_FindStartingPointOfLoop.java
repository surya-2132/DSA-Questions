package LinkedList.Essential.HareAndTortoise;

import LinkedList.SingleLL.ListNode;

public class Q4_FindStartingPointOfLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 2; i <= 6; i++) {
            head.add(i);
        }

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

        ListNode loopStartingNode = startingPoint(head);
        System.out.println("Loop Starting Point: " + loopStartingNode.val);
    }


    public static ListNode startingPoint(ListNode head){
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){

                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;  //or return fast
            }
        }
        return null;
    }
}
