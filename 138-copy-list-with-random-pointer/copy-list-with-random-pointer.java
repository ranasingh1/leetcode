/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create clone nodes and insert them into the original list
        Node temp = head;
        while (temp != null) {
            Node clone = new Node(temp.val);
            clone.next = temp.next;
            temp.next = clone;
            temp = clone.next;
        }

        // Step 2: Set up random pointers for the cloned nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        Node dummyHead = new Node(0);
        Node cloneTemp = dummyHead;
        temp = head;

        while (temp != null) {
            cloneTemp.next = temp.next;
            cloneTemp = cloneTemp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyHead.next;
    }
}
