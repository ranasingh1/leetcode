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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify code
        ListNode current = dummyHead;  // Pointer to build the result list
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values from the nodes, or 0 if the node is null
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Sum the values of the two nodes and the carry
            int sum = val1 + val2 + carry;
            
            // Calculate the new carry and the current digit
            carry = sum / 10;
            int digit = sum % 10;
            
            // Add the current digit as a new node
            current.next = new ListNode(digit);
            current = current.next;

            // Move to the next nodes in l1, l2 if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the next node of dummyHead, as the dummy node is just a placeholder
        return dummyHead.next;
    }
}
