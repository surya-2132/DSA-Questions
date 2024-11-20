package LinkedList.SingleLL;


public class SingleLinkedList {

    public ListNode deleteHead(ListNode head) {
        ListNode temp = head;
        // if no elem present or only one elem is present, return null
        if(temp == null || temp.next == null){
            return null;
        }

        // if more than one elem present, move the temp ptr to one step and return that temp
        temp = temp.next;
        return temp;
    }


    public ListNode deleteLast(ListNode head){
        ListNode temp = head;

        if(temp == null || temp.next == null){
            return null;
        }

        while(temp != null){
            //when 2->3 null we found our tail elem (3) so stop then then change 2->null
            if(temp.next.next == null){
                temp.next = null;
            }
            //till then move to the next ptr
            temp = temp.next;
        }

        //asked in qus - return the head of the modified list.
        return head;
    }


    public static ListNode deleteAtIndex(ListNode head, int idx){
        ListNode temp = head;
        ListNode prev = null;

        if(temp == null || temp.next == null){
            return null;
        }

        //if its head(first position) directly moves temp ptr and return
        if(idx == 1){
            temp = temp.next;
            return temp;
        }

        int count = 1;
        while(temp != null){
            if(idx == count){ //if we reach the position, assign like 2->3->4 to 2->4
                prev.next = prev.next.next;
                return head;
            }

            //till then move the pointers along with count variable
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }


    public ListNode deleteElement(ListNode head, int elem) {

        ListNode temp = head;
        ListNode prev = null;

        if(temp == null || temp.next == null){
            return null;
        }

        if(elem == temp.data){
            temp = temp.next;
            return temp;
        }

        while(temp != null){
            if(elem == temp.data){
                prev.next = temp.next;
                return head;
            }

            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    public static ListNode insertFirst(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }


    public static ListNode insertLast(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        ListNode temp = head;

        // If the list is empty, the new node becomes the head.
        if(temp == null){
            return newNode;
        }

        // Traverse to the end of the list.
        while(temp.next != null){
            temp = temp.next;
        }

        // Insert the new node at the end.
        temp.next = newNode;
        newNode.next = null;

        return head;
    }


    public static ListNode insertAtIndex(ListNode head, int idx, int data){
        ListNode newNode = new ListNode(data);
        ListNode temp = head;

        // Case 1: Empty list -> Indirectly handles if its []
        // Case 2: Inset at head which is K == 1
        if(idx == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }

        // Case 3: Middle case -> iterate till insert position - 1
        // Case 4: Indirectly handles tail insertion
        int count = 1;
        while(temp != null){
            if(count == idx-1){
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
            count++;
        }

        return head;
    }



    public ListNode insertBeforeX(ListNode head, int beforeElem, int data) {
        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        ListNode prev = null;

        // If the list is empty, return as is
        if (head == null) {
            return null;
        }

        // Handle insertion before the head
        if (head.data == beforeElem) {
            newNode.next = head; // Link the new node to the current head
            head = newNode;
            return head; // New node becomes the head
        }

        // Traverse the list to find the node with value X
        //noinspection DuplicatedCode
        while (temp != null) {
            if (temp.data == beforeElem) {
                newNode.next = temp; // Link the new node to the current node
                prev.next = newNode; // Link the previous node to the new node
                return head; // Return modified list
            }
            prev = temp; // Move previous pointer
            temp = temp.next; // Move current pointer
        }

        // If X is not found, return the original list
        return head;
    }

}
