package LinkedList.Easy;

import LinkedList.DoubleLL.ListNode;

public class ConvertArrayToDLL {
    public static void main(String[] args) {

    }

    public ListNode arrayToLinkedList(int[] nums) {
        //Creating head on our own
        ListNode head = new ListNode(nums[0]);
        ListNode prev = head; //variable name can also be temp

        for(int i = 1; i < nums.length; i++){
            ListNode newNode = new ListNode(nums[i], null, prev);
            newNode.prev = prev;
            prev.next = newNode;
            prev = newNode; //moving prev to newly added now as reference for upcoming nodes
        }

        return head;
    }
}
