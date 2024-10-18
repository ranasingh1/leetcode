class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;

        while (present != null) {
            ListNode next = present.next; 
            present.next = prev;          
            prev = present;                // Move prev to current node
            present = next;                // Move to the next node
        }

        return prev; // prev is now the new head of the reversed list
    }
}
