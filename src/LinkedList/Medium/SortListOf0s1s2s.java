package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class SortListOf0s1s2s {
    public static void main(String[] args) {
        // Create dummy linked list: 1 -> 2 -> 0 -> 1 -> 2 -> 0
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);

        System.out.println("Original List:");
        ListNode.printList(head);

        head = sortList(head);

        System.out.println("Sorted List:");
        ListNode.printList(head);
    }


    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        //Dummy nodes to point to heads of three lists
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Pointers to current last nodes of three lists
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;

        //Traverse the original list and distribute the nodes into three lists
        while(temp != null){
            if(temp.val == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.val == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        // Connect the three lists together
        // if no 1's present in list 0's next points to 2,
        // if 2 also no there automatically 2's next is null so 0's next will be null
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        //start of list will be from 0, if no 0 present it will start from or 2 else null
        ListNode newHead = zeroHead.next;
        return newHead;
    }
}