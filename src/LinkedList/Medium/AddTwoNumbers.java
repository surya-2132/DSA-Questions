package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;


public class AddTwoNumbers {
    public static void main(String[] args) {
        // Create dummy linked list: 1 -> 2 -> 0 -> 1 -> 2 -> 0
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        System.out.println(addTwoNumbers(head, head2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carryOver = 0;

        //can loop even if we have 1 listNode left
        while(t1 != null || t2 != null){
            int sum = carryOver; //sum = 0;

            if(t1 != null)  sum = sum + t1.val;
            if(t2 != null)  sum = sum + t2.val;

            ListNode newNode = new ListNode(sum % 10);
            carryOver = sum / 10;
            curr.next = newNode;
            curr = curr.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }

        //if we have anything left
        if(carryOver > 0){
            ListNode newNode = new ListNode(carryOver);
            curr.next = newNode;
        }

        return dummyNode.next;
    }
}