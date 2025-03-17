class FrontMiddleBackQueue {

    Deque<Integer> left, right;
    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();


    }
    
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
                left.addLast(val);

    }
    
    public void pushBack(int val) {
     right.addLast(val);
        balance();

    }
    
    public int popFront() {
          if (left.isEmpty() && right.isEmpty()) return -1;
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return val;

    }
    
    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = left.size() >= right.size() ? left.pollLast() : right.pollFirst();
        balance();
        return val;

        
    }
    
    public int popBack() {
    if (right.isEmpty() && left.isEmpty()) return -1;
        int val = right.isEmpty() ? left.pollLast() : right.pollLast();
        balance();
        return val;

    }

    private void balance(){
        if(left.size()>right.size()+1){
         right.addFirst(left.removeLast());
        }else if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */