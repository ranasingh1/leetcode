/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // Cycle detected, calculate the cycle's length
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                // Step 2: Move one pointer ahead by 'length' steps
                ListNode f = head;
                ListNode s = head;
                while (length > 0) {
                    s = s.next;
                    length--;
                }

                // Step 3: Move both pointers until they meet at the start of the cycle
                while (f != s) {
                    f = f.next;
                    s = s.next;
                }

                return f; // The start of the cycle
            }
        }

        return null; // No cycle
    }
}
