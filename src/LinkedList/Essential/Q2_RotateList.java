package LinkedList.Essential;

import LinkedList.SingleLL.ListNode;

public class Q2_RotateList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        for(int i = 2; i < 18980; i++) {
            listNode.add(i);
        }

        System.out.println(rotateList(listNode, 4785 ));
    }

    public static ListNode rotateList(ListNode head, int k){

        if(k <= 0 || head == null || head.next == null) return head;
        ListNode tail = head;

        //find length of the list
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        tail.next = head;

        int rotate = k % length;    //rotation count using %
        int size = length-rotate; //how much actually we need to move from head to rotate

        ListNode newTail = head;
        for(int i = 0; i < size -1; i++){
            //size -1 coz we using next else it will surpass actual count
            newTail = newTail.next;
        }

        head = newTail.next;//after 3 now 4 is new head
        newTail.next = null;//now after 3 no ele node so make null

        return head;
    }
}
