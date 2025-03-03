class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

     Stack<Integer> stack = new Stack<>();
     int n = nums.length;
     int toRemove = n-k;

     for(int num:nums){
            while (!stack.isEmpty() && stack.peek() > num && toRemove > 0) {
                stack.pop();
                toRemove--;
            }
            stack.push(num);

     }

       int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = stack.get(i);
        }
        
        return result;

    
    }
}