package LinkedList.Essential;

import LinkedList.SingleLL.ListNode;
import java.util.ArrayList;
import java.util.List;

public class SegregateOddEven {

    public static void main(String[] args) {

    }


    //Brute force
    //TC -> O(N), SC -> O(N)
    public ListNode segregateBrute(ListNode head){

        if (head == null || head.next == null)
            return head;

        List<Integer> arrayList = new ArrayList<>();


        ListNode temp = head;
        while(temp != null && temp.next != null){
            arrayList.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arrayList.add(temp.val);
        }



        temp = head.next;
        while(temp != null && temp.next != null){
            arrayList.add(temp.val);
            temp = temp.next.next;
        }

        if(temp != null){
            arrayList.add(temp.val);
        }



        int i = 0;
        temp = head;
        while(temp != null) {
            temp.val = arrayList.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }


    //Optimal force
    //TC -> O(N), SC -> O(1)
    public ListNode segregateBetter(ListNode head){
        if (head == null || head.next == null)
            return head;

        /*Initialize pointers for odd
        and even nodes and keep
        track of the first even node*/
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        /* Connect the last odd
       node to the first even node*/
        odd.next = firstEven;

        return head;
    }

}
