class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
      expCount(nums, 0, 0, target);
      return count;

    }


      private void expCount(int [] nums, int i, int sum, int target){
            if (i == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            expCount(nums, i + 1, sum + nums[i], target);
            expCount(nums, i + 1, sum - nums[i], target);
        }
          
      }
}