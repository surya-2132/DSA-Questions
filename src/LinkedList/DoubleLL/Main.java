package LinkedList.DoubleLL;

public class Main {
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        ListNode head = new ListNode(10);
        head = dll.insertBeforeHead(head, 5);   // Insert 5 before head
        head = dll.insertBeforeTail(head, 20);     // Insert 20 at tail
        head = dll.insertBeforeKthPosition(head, 15, 3); // Insert 15 before 3rd position

        // Print the list after initialization
        dll.printList(head);


        // Test delete operations
        head = dll.deleteHead(head);  // Delete the head
        dll.printList(head);

        head = dll.deleteTail(head);  // Delete the tail
        dll.printList(head);

        head = dll.deleteKthElement(head, 2); // Delete 2nd element
        dll.printList(head);



        // Test insert operations
        head = dll.insertBeforeHead(head, 30); // Insert 30 at the head
        dll.printList(head);

        head = dll.insertBeforeTail(head, 40); // Insert 40 before tail
        dll.printList(head);

        head = dll.insertBeforeKthPosition(head, 25, 2); // Insert 25 before 2nd position
        dll.printList(head);
    }
}
