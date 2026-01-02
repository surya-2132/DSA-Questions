package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class Q3_MergeTwoSortedList {


    //// Space Complexity here is O(N) since we created the new node and ADDING VALUES INTO IT
    /// instead of redirecting nodes link
    public ListNode mergeTwoListsBrute(ListNode list1, ListNode list2) {
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

    //// Here instead of creating a completely new list from dummyNode we are just redirecting the links only.
    public static ListNode mergeTwoSortedListOptimal(ListNode head1, ListNode head2){
        ListNode t1 = head1;
        ListNode t2 = head2;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        dummyNode.next = null;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        //instead of traversing just rejoin the link to available list (t1//t2)
        if(t1 != null) temp.next = t1;
        if(t2 != null) temp.next = t2;

        return dummyNode.next;
    }
}