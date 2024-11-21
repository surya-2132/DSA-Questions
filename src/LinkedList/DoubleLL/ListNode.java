package LinkedList.DoubleLL;

public class ListNode {
    int val;
    public ListNode next;
    public ListNode prev;

    public ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    public ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    public ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
