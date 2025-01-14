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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode temp = head;
        ListNode dummyLess = new ListNode(0);
        ListNode lessTail = dummyLess;
        ListNode dummyGreater = new ListNode(0);
        ListNode greaterTail = dummyGreater;
        
        while(temp!=null){
            if(temp.val<x){
                lessTail.next = new ListNode(temp.val);
                lessTail = lessTail.next;
            }else{
                greaterTail.next = new ListNode(temp.val);
                greaterTail = greaterTail.next;
            }
           temp = temp.next;   
        }

        lessTail.next = dummyGreater.next;
        return dummyLess.next;
    }
}