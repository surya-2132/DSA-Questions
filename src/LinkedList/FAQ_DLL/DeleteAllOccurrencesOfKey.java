package LinkedList.FAQ_DLL;

import LinkedList.DoubleLL.ListNode;

public class DeleteAllOccurrencesOfKey {

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;

        while(temp != null){
            if(temp.val == target){
                if(temp == head){
                    head = head.next; //removing head
                }

                // we are at temp, now creating: prevNode <-> temp <-> nextNode
                ListNode prevNode = temp.prev;
                ListNode nextNode = temp.next;

                if(prevNode != null){   //checking if prevNode head
                    prevNode.next = nextNode;
                }

                if(nextNode != null){   //checking if nextNode tail
                    nextNode.prev = prevNode;
                }

                temp = nextNode; //Moving temp node to the next place
            }
            // if temp is not standing at targeted value, just move then pointer
            else{
                temp = temp.next;
            }
        }

        return head;
    }

}
