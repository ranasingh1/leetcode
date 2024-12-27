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
    public ListNode rotateRight(ListNode head, int k) {
 if (head == null || head.next == null || k == 0) {
            return head; 
        }

        int length = length(head); 
        k = k % length; 
        if (k == 0) {
            return head; 
        }

        int rotateAt = length - k;
        ListNode temp = head;
        ListNode lastNode = get(length-1, head);
        ListNode rotateNode = get(rotateAt-1, head);
        System.out.println(rotateNode.val);
        ListNode newHead = get(rotateAt, head);
                System.out.println(newHead.val);

        rotateNode.next = null;
        lastNode.next = head;
        head = newHead;
        return head;
    }

    public int length(ListNode head){
        ListNode node = head;
        int length = 1;
        while(node.next!=null){
            node = node.next;
            length++;
        }
        return length;
    }

    public ListNode get(int index, ListNode head){
        ListNode temp = head;
         for(int i =0 ; i<index; i++){
            temp = temp.next;         
        }
        return temp;
    }
}