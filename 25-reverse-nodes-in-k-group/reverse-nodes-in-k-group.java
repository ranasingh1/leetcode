/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // Calculate the total number of nodes in the list
        ListNode current = head;
        int totalNodes = 0;
        while (current != null) {
            totalNodes++;
            current = current.next;
        }

        // Initialize pointers for the reversal process
        ListNode prev = null;
        ListNode currentHead = head;

        // Main loop to reverse in groups of size k
        while (totalNodes >= k) {
            ListNode lastNodeOfPrevPart = prev;
            ListNode lastNodeOfSublist = currentHead;
            ListNode next = null;

            // Reverse k nodes
            current = currentHead;
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect with the previous part
            if (lastNodeOfPrevPart != null) {
                lastNodeOfPrevPart.next = prev;
            } else {
                head = prev; // New head after reversing the first group
            }

            // Connect with the next part
            lastNodeOfSublist.next = current;

            // Prepare for the next group of k nodes
            prev = lastNodeOfSublist;
            currentHead = current;
            totalNodes -= k;
        }

        return head;
    }
}
