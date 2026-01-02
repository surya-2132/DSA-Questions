package LinkedList.Essential;

import LinkedList.Medium.Q3_MergeTwoSortedList;
import LinkedList.SingleLL.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q4_Merge_K_Sorted_List {

    public static void main(String[] args) {
        // Creating sample sorted linked lists
        // List 1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));

        // List 2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // List 3: 2 -> 6
        ListNode l3 = new ListNode(2, new ListNode(6));

        // ---------- Testing Optimal Method ----------
        ListNode[] lists = new ListNode[]{l1, l2, l3};

        // ---------- Testing Brute Force Method ----------
        List<ListNode> listOfLists = new LinkedList<>();
        listOfLists.add(l1);
        listOfLists.add(l2);
        listOfLists.add(l3);

        System.out.print("Merged List (Optimal): " + mergeKSortedListBrute(listOfLists));
    }

    /**
     * Brute Force Approach:
     * ---------------------
     * - Start with the first linked list.
     * - Iteratively merge it with the next list using mergeTwoSortedList.
     * - Final merged list is obtained after merging all k lists.

     * Time Complexity (TC):
     * - O(N * K)
     *   where:
     *     N = total number of nodes across all lists
     *     K = number of linked lists

     * Explanation:
     * - Each merge can take O(N) in the worst case.
     * - We perform (K - 1) merges.

     * Space Complexity (SC):
     * - O(1) auxiliary space
     * - Merging is done in-place using existing nodes.
     */
    public static ListNode mergeKSortedListBrute(List<ListNode> listOfListNodes){

        ListNode head = listOfListNodes.getFirst();
        for (int i = 1; i < listOfListNodes.size(); i++){
            head = Q3_MergeTwoSortedList.mergeTwoSortedListOptimal(
                    head, listOfListNodes.get(i));
        }

        return head;
    }


    /**
     * Optimal Approach (Divide & Conquer using Queue):
     * -----------------------------------------------
     * - Push all non-null lists into a queue.
     * - Repeatedly take two lists from the queue and merge them.
     * - Push the merged list back into the queue.
     * - Continue until only one list remains.

     * Time Complexity (TC): - O(N log K)
     *   where:
     *     N = total number of nodes
     *     K = number of linked lists

     * Explanation:
     * - Each node is processed at every level of merging.
     * - Number of merge levels ≈ log K.

     * Space Complexity (SC): - O(K) auxiliary space due to the queue.
     * - No extra space used for node creation (in-place merging).
     */
    public static ListNode mergeKListsOptimal(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        Queue<ListNode> q = new LinkedList<>();

        // Add all non-null lists to the queue
        for (ListNode l : lists) {
            if (l != null) q.offer(l);
        }

        // Merge lists in pairs
        while (q.size() > 1) {
            q.offer(mergeList(q.poll(), q.poll()));
        }

        return q.poll();
    }

    /**
     * Helper method to merge two sorted linked lists.
     * Time Complexity: - O(n1 + n2)
     * Space Complexity: - O(1) auxiliary space
     */

    //static inner class
    static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return head.next;
    }
}
