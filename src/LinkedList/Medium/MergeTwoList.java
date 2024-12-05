package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ansNode = new ListNode(0); // Dummy node to simplify merging
        ListNode ansNodeHead = ansNode; // Pointer to build the new list

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ansNode.next = list1;   // Link current node to list1
                list1 = list1.next; // Move list1 forward
            }else{
                ansNode.next = list2;   // Link current node to list2
                list2 = list2.next; // Move list2 forward
            }

            ansNode = ansNode.next; // Move ansNode one step forward
        }

        // Link the remaining nodes
        if(list1 != null){
            ansNode.next = list1;
        }
        else{
            ansNode.next = list2;
        }

        // Return the merged list, skipping the first initialized dummy node
        return ansNodeHead.next;
    }
}
