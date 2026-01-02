package LinkedList.Essential;

import LinkedList.Medium.Q3_MergeTwoSortedList;
import LinkedList.SingleLL.ListNode;

public class Q5_SortListNode_LL {

    //TC -> O(N + N/2) + O(Log N)
    //SC -> O(1)
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(13);
        listNode.add(30);
        listNode.add(98);
        listNode.add(57);
        listNode.add(63);
        listNode.add(23);
        listNode.add(31);
        listNode.add(44);
        listNode.add(11);
        System.out.println(sortListNodes(listNode));
    }

    public static ListNode sortListNodes(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode middle = Q0_FindMiddle.findMiddle(head); // middle function
        ListNode leftHead = head; //starts at head
        ListNode rightHead = middle.next; //starts from middle
        middle.next = null;

        leftHead = sortListNodes(leftHead);
        rightHead = sortListNodes(rightHead);

        return Q3_MergeTwoSortedList.mergeTwoSortedListOptimal(leftHead, rightHead); //merging function

    }
}
