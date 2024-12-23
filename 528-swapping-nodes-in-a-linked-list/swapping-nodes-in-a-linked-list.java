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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null){
            return head;
        }
    int length = 1;
    ListNode current = head;
    while(current!=null){
        current = current.next;
        length++; 
    }

    int indexFromEnd = length-k;
       System.out.println(indexFromEnd);


   ListNode fn = getIndex(k, head);
   System.out.println(fn.val);
   ListNode sn = getIndex(indexFromEnd, head);
   System.out.println(sn.val);
   int temp = fn.val;
   fn.val = sn.val;
   sn.val = temp;

    return head;
    }

    private ListNode getIndex(int index, ListNode head){
            ListNode current = head;
          for(int i = 1; i<index; i++){
            current = current.next;
          }

          return current;

    }

}