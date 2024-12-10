package LinkedList.FAQ_DLL;

import LinkedList.DoubleLL.ListNode;

public class RemoveDuplicatesInSortedList {

    public ListNode removeDuplicates(ListNode head) {

        ListNode temp = head;

        // Traverse the list until temp is the last node
        while(temp != null){
            ListNode nextNode = temp.next;

            // SKIP(Remove) all duplicate nodes
            while(nextNode != null && nextNode.val == temp.val){
                nextNode = nextNode.next;
            }

            // Even there's only unique, no need to do extra check, again relink the present link
            // Link the current node to the next non-duplicate node
            temp.next = nextNode;
            if(nextNode != null){   // if nexNode is tail and to avoid NullPointerException
                nextNode.prev = temp;  // Update previous pointer of next non-duplicate node
            }

            temp = temp.next;  // Move to the next node
        }

        return head;
    }
}
