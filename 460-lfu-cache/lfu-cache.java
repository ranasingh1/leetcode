class Node {
    public int key;
    public int val;
    public int useCounter;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.useCounter = 1;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void removeNode(Node node) {
        Node pre = node.prev;
        Node nex = node.next;
        pre.next = nex;
        nex.prev = pre;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
}

class LFUCache {
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoublyLinkedList> freqMap;
    private int minFreq;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);
        updateNodeFrequency(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            updateNodeFrequency(node);
        } else {
            if (nodeMap.size() == capacity) {
                DoublyLinkedList list = freqMap.get(minFreq);
                Node nodeToRemove = list.tail.prev;
                list.removeNode(nodeToRemove);
                nodeMap.remove(nodeToRemove.key);
                if (list.isEmpty()) {
                    freqMap.remove(minFreq);
                }
            }

            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            minFreq = 1;
            freqMap.putIfAbsent(1, new DoublyLinkedList());
            freqMap.get(1).addNode(newNode);
        }
    }

    private void updateNodeFrequency(Node node) {
        int freq = node.useCounter;
        freqMap.get(freq).removeNode(node);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        node.useCounter++;
        freqMap.putIfAbsent(node.useCounter, new DoublyLinkedList());
        freqMap.get(node.useCounter).addNode(node);
    }
}