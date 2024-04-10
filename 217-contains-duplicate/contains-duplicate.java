class Solution {
    public boolean containsDuplicate(int[] nums) {
        int end = nums.length - 1;
        boolean changed = true;
        int t;
        
        while (end > 0) {
            changed = false;
            for (int i = 0; i < end; i++) {
                if (nums[i] == nums[i+1]) return true;
                if (nums[i] > nums[i+1]) {
                    t = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = t;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
            end--;
        }
        
        return false;
	}
}