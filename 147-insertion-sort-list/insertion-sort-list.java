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
    public ListNode insertionSortList(ListNode head) {
              ListNode d = new ListNode(0, head);
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            
            ListNode tmp = d;
            while (curr.val > tmp.next.val) {
                tmp = tmp.next;
            }
            
            prev.next = curr.next;
            curr.next = tmp.next;
            tmp.next = curr;
            curr = prev.next;
        }
        return d.next;
    }
}