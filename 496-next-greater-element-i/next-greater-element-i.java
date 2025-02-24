class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     
       Deque<Integer> deque = new ArrayDeque<>();
       Map<Integer, Integer> map = new HashMap<>();

       map.put(nums2[0], -1);
       deque.push(nums2[0]);

       for(int i = 1; i<nums2.length; i++){
        while(deque.size()!=0 && nums2[i]> deque.peek()){
            map.replace(deque.pop(), nums2[i]);
        }
        deque.push(nums2[i]);

         map.put(nums2[i], -1);

       }

       int[] result = new int[nums1.length];

       for(int i = 0; i<nums1.length; i++){
        result[i] = map.get(nums1[i]);
       }

       return result;
        
    }
}