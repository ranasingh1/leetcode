class MyCircularQueue {
    private int[] data;
    private int front;
    private int end;
    private int size;
    
    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        end = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[end] = value;
        end = (end + 1) % data.length; 
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length; 
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : data[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : data[(end - 1 + data.length) % data.length];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
}
