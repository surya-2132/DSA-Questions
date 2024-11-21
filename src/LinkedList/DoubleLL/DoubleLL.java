package LinkedList.DoubleLL;

public class DoubleLL {

    public ListNode deleteHead(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode temp = head;
        head = temp.next; // Move 'head' to the next node
        head.prev = null;
        temp.next = null; //Decoupling head's previous node separately

        return head;
    }



    public ListNode deleteTail(ListNode head) {

        if(head == null){
            return null;
        }

        // Navigate to the end of the linked list
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        //The last node's prev node is tail that is temp.prev
        ListNode tail = temp.prev;
        tail.next = null;
        temp.prev = null;

        return head;
    }


    public ListNode deleteKthElement(ListNode head, int k) {

        //Case 1: No element
        if(head == null){
            return null;
        }

        int count = 1;
        ListNode temp = head;
        while(temp != null){
            if(count == k){
                break;
            }
            temp = temp.next;
            count++;
        }

        //Special Case: If k is greater than length of the list
        if (temp == null) {
            return head;
        }

        ListNode prev = temp.prev;
        ListNode front = temp.next;

        //Case 2: only one element in list
        if(prev == null && front == null){
            return null;
        }


        //Case 3: delete from previous -> deleteHead
        else if(prev == null){
            //deleteHead(head); -> No need to write this function, simply do as
            head = front;
            front.prev = null;
        }

        //Case 4: delete from last -> deleteLast
        else if(front == null){
            //deleteTail(head); -> No need to write this function, simply do as
            prev.next = null;
        }

        else{

            //Case 5: delete from 2nd elem to n-th elem (Middle elem which has both prev & front)
            prev.next = front;
            front.prev = prev;
            temp.next = null;
            temp.prev = null;

        }

        return head;

    }


    // You will only be given the node's reference, not the head of the list.
    // It is guaranteed that the given node will not be the head of the list.
    public void deleteGivenNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode front = node.next;

        if(front == null){
            prev.next = null;
            node.prev = null;
            return;
        }

        prev.next = front;
        front.prev = prev;
        node.next = null;
        node.prev = null;

        return;
    }



    public ListNode insertBeforeHead(ListNode head, int val) {
        if(head == null){
            return null;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        head.prev = null; //because again we reassigned head as first node
        return head;
    }


    public ListNode insertBeforeTail(ListNode head, int val) {
        if(head == null){
            return new ListNode(val);
        }

        ListNode temp = head;
        ListNode prev = null;
        //noinspection ConstantValue
        while(temp != null){
            if(temp.next == null){
                ListNode newNode = new ListNode(val);
                newNode.next = temp;
                temp.prev = newNode;
                newNode.prev = prev;
                if (prev != null) {
                    prev.next = newNode;
                }else{ // If prev is null, we are inserting in front of the head
                    head = newNode;
                }
                break;  // Exit the loop after the insertion
            }

            //Increment operations
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public ListNode insertBeforeKthPosition(ListNode head, int val, int k) {
        if(head == null){
            return null;
        }

        if(k == 1){
            return insertBeforeHead(head, val);
        }

        ListNode temp = head;
        ListNode prev = null;
        int count = 1;
        while(temp != null){
            if(count == k){
                break;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }

        ListNode newNode = new ListNode(val, temp, prev); //(value, nextNode, prevNode) is the order
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = temp;
        temp.prev = newNode;

        return head;
    }



    // You will only be given the node's reference, not the head of the list.
    // It is guaranteed that the given node will not be the head of the list.
    public void insertBeforeGivenNode(ListNode node, int val) {
        ListNode prev = node.prev;
        ListNode front = node.next;
        ListNode newNode = new ListNode(val);

        // Since we have to insert before given node,
        // even if they give tail no issues upon null pointer
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = node;
        node.prev = newNode;
    }


    // Print method for the Doubly Linked List
    public void printList(ListNode head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        ListNode temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
