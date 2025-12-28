package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class OddEvenList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {

        //empty list || single elem list
        if (head == null || head.next == null)
            return head;

        //Initialize pointers for odd and even nodes
        //and keep track of the first even node
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        while(even.next != null && even.next.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // Connect the last odd node to the first even node
        odd.next = firstEven;
        return head;
    }
}
