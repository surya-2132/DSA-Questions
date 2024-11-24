package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class AddOneToANumber {

    public static void main(String[] args) {

    }

    public static ListNode addOne(ListNode head) {
        int carryOver = recCarryOver(head);

        //if we returned 999 as 000 create new node with val 1 and make 1000
        if(carryOver == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = head; // return from 1 as head
            return newNode;
        }

        return head; //else return usual head

    }

    public static int recCarryOver(ListNode temp){

        //base case: when we reach the end of the list start carrying 1
        if(temp == null){
            return 1;
        }

        //going to the next node, then it will get back newly added value
        int carryOver = recCarryOver(temp.next);

        //summing up curr node val with carryOver value which can be 1 or 0
        temp.val = temp.val + carryOver; //9 + 1 = 10 or 1to8 + 1 = ans

        if(temp.val < 10){ //if is less than return 0 like 1 to 9 after the sum
            return 0;
        }

        //if the number is 10, then put 0 for that node, carryOver 1 again
        temp.val = 0;
        return 1;
    }

}
