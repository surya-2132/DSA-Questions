package LinkedList.Easy;

import LinkedList.SingleLL.ListNode;

public class ReverseList {

    public static void main(String[] args) {

        // Create the head of the list
        ListNode head = new ListNode(1);

        // Add nodes to the list
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);

        System.out.println("Original List: ");
        ListNode.printList(head);
        ListNode reversedIterative = reverseListIterative(head);
        System.out.println("\nReversed List (Iterative): ");
        ListNode.printList(reversedIterative);

        // Reverse it back using the recursive method
        ListNode reversedRecursive = reverseListRecursive(reversedIterative);
        System.out.println("\nReversed List (Recursive, back to original): ");
        ListNode.printList(reversedRecursive);
    }


    //Iterative approach
    public static ListNode reverseListIterative(ListNode head) {
        // Initialize pointers: prev is initially null, curr starts at head.
        // null - 1->  2-> 3->4->5->null
        // prev- curr- next
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next; // Store the next node to avoid losing reference.

        // Iterate until the current node is null (end of the list).
        while (curr != null) {
            curr.next = prev; // Reverse the current node's pointer to point to the previous node.
            prev = curr;      // Move prev one step forward (to the current node).
            curr = next;      // Move curr one step forward (to the next node).
            if (next != null) { //anyway, we have to go till null, so don't go after null
                next = next.next; // Update next to the next node in the original list.
            }
        }
        //.                  curr    prev&next will be here
        // null<-1<-2<-3<-4  <-5   - null
        // prev will now point to the new head of the reversed list.
        return prev;
    }


    //Recursive approach
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next); //its like index + 1
        ListNode front = head.next;
        //redirecting node's pointers
        front.next = head;
        head.next = null;

        return newHead;
    }
}
