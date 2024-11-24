package LinkedList.Medium;

import LinkedList.SingleLL.ListNode;

public class IntersectionOfTwoNodes {


    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        //Traverse both the list from start to end anc calc the length
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0;
        int n2 = 0;

        //calc first list's length
        while(temp1 != null){
            temp1 = temp1.next;
            n1++;
        }

        //calc second list's length
        while(temp2 != null){
            temp2 = temp2.next;
            n2++;
        }

        // Reassign the starting point of node to the start of the respective node
        temp1 = headA;
        temp2 = headB;
        if(n1 < n2){    //collpnt(small, larger, diff)  -  temp1 is smaller here
            return collisionPoint(temp1, temp2, n2 - n1);
        }else{          //collpnt(small, larger, diff)  -  temp2 is smaller here
            return collisionPoint(temp2, temp1, n1 - n2);
        }
    }

    //We will consider always temp2 as largest for just for calculation
    private ListNode collisionPoint(ListNode temp1, ListNode temp2, int d){
        //since we considered second node is the largest
        //move second node till the difference we calculated
        //eg : list1 len = 7, list2 len = 5, d = n1-n2 -> 7 - 5 = 2, move 2 nodes on larger list
        while(d > 0){
            d--;
            temp2 = temp2.next;
        }


        //once they have the same point, iterate until we find diff value on both
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 != null || temp2 != null){
            return temp1; // or return temp2 also fine
        }else{
            return null;
        }
    }


    //Optimal Solution
    public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
        // Initialize two pointers, d1 and d2 to the heads of the two lists
        ListNode d1 = headA;
        ListNode d2 = headB;

        // Traverse both lists until the pointers meet
        while (d1 != d2) {
            // Move pointer d1 to the head of the second list if it reaches the end of the first list
            d1 = (d1 == null) ? headB : d1.next;

            // Move pointer d2 to the head of the first list if it reaches the end of the second list
            d2 = (d2 == null) ? headA : d2.next;
        }

        return d1; // Return the intersection node
    }
}
