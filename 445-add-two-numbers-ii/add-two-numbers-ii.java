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
       ListNode rl1 =  reverse(l1);
       ListNode rl2 =  reverse(l2);
       ListNode dummyhead = new ListNode(0);
       ListNode temp = dummyhead;
       int carry = 0;

       while(rl1!=null || rl2!=null || carry!=0){
       
       int val1 = (rl1 != null) ? rl1.val : 0;
       int val2 = (rl2 != null) ? rl2.val : 0;
      
      int sum = val1 + val2 + carry;

      carry = sum/10;
      int digit = sum%10;

      temp.next = new ListNode(digit);
      temp = temp.next;

         if (rl1 != null) rl1 = rl1.next;
         if (rl2 != null) rl2 = rl2.next;



       }

       return reverse(dummyhead.next);

    
             
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        while(current!=null){
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null){
            next = next.next;
            }

        }
      return prev;

    }
}