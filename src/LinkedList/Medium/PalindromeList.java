package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

import java.util.Stack;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        // Traverse the linked list and push values onto the stack
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // Reset the temporary pointer back to the head of the linked list
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
