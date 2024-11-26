package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class DeleteMiddleNode {

    public ListNode deleteMiddleBrute(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;

        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        temp = head;
        int middleNode = count / 2;
        for(int i = 1; i < middleNode; i++){ // 1 < 3, 2 < 3 so from head move times
            temp = temp.next;
        }

        // Skip 4: 3 -> 4 -> 5 temps are 3 now, we are doing 3's next to 5
        temp.next = temp.next.next;

        return head;
    }

//    public ListNode deleteMiddleOptimal(ListNode head) {
//
//    }
}
