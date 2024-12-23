class MyLinkedList {
    public class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) { //index out of bound or invalid index
            return -1;
        }
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // now current is at the node of which we want to acess the data
        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (size == 0) { // if LL is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (size == 0) { // empty LL
            head = tail = newNode;
        } 
            tail.next = newNode;
            tail = newNode;
        
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) { // same old invalid index case
            return;
        }
        if (index == 0) { //adfirst
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node current = head;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) { //adlast maybe
            tail = newNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            int i = 0;
            while (i < index - 1) {
                current = current.next;
                i++;
            }
            if (current.next != null) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
            }
        }
        size--;
    }
}





/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */