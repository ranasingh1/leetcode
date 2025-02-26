class CustomStack {

    private int D_S;
    protected int[] data;
    int ptr = -1;

    public CustomStack(int maxSize) {
        this.D_S = maxSize;
        this.data = new int[maxSize];

    }
    
    public void push(int x) {
        if(!isFull()){
         ptr++;
        data[ptr] = x;
        }
    }
    
    public int pop() {
        if(!isEmpty()){
       return data[ptr--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i<k && i<=data.length-1; i++){
            System.out.println(data[i]);
            data[i]=data[i] + val;
        }

    }

    private boolean isFull(){
      if(ptr==data.length-1){
        return true;
      }
      return false;
    }

    private boolean isEmpty(){
        return ptr==-1;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */