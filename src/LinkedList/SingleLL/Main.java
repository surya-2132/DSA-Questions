package LinkedList.SingleLL;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        // Create and initialize a singly linked list
        ListNode head = new ListNode(10);
        head = SingleLinkedList.insertFirst(head, 5);  // Insert 5 at the beginning
        head = SingleLinkedList.insertLast(head, 20);  // Insert 20 at the end
        head = SingleLinkedList.insertAtIndex(head, 2, 15); // Insert 15 at index 2

        // Print the list after initialization
        ListNode.printList(head);

        // Test delete operations
        head = sll.deleteHead(head); // Delete the head
        ListNode.printList(head);

        head = sll.deleteLast(head); // Delete the last node
        ListNode.printList(head);

        head = SingleLinkedList.deleteAtIndex(head, 2); // Delete node at index 2
        ListNode.printList(head);

        // Test insert operations
        head = SingleLinkedList.insertFirst(head, 30); // Insert 30 at the beginning
        ListNode.printList(head);

        head = SingleLinkedList.insertLast(head, 40); // Insert 40 at the end
        ListNode.printList(head);

        head = SingleLinkedList.insertAtIndex(head, 3, 25); // Insert 25 at index 3
        ListNode.printList(head);

        // Test deleteElement
        head = sll.deleteElement(head, 25); // Delete node with value 25
        ListNode.printList(head);

        // Test insertBeforeX
        head = sll.insertBeforeX(head, 40, 35); // Insert 35 before 40
        ListNode.printList(head);
    }
}
