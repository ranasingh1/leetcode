/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

    if(head == null){
        return head;
    }

    flattenRecursively(head);

    return head;

    }

    public Node flattenRecursively(Node temp){
       Node current = temp;
       Node last = null;

        while(current!=null){
         Node next = current.next;
            if(current.child != null){
                Node childLast = flattenRecursively(current.child);
                current.next = current.child;
                current.child.prev = current;

                 if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

               current.child = null;

                last = childLast;
            
            }else{
                last = current;
            }

            current = next;


        }
        return last;

    }


}