class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        sort(nums, 0, nums.length-1);
        //set beacause we want to store a unique element
        Set<List<Integer>> s = new HashSet <>();
      List<List<Integer>> output = new ArrayList<>();
     for(int i = 0; i<nums.length; i++){
        int low = i+1;
        int high = nums.length-1;
        while(low <high){
            int sum = nums[i]+ nums[low]+ nums[high];
            if(sum == target){
                s.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--; 
            }else if(sum <target){
                low++;
            }else{
                high --;
            }
        }

     }
          output.addAll(s);
        return output;           
    }
    public static  void sort(int [] nums, int l, int h ){
        if(l>=h){
            return;
        }
        int s = l;
        int e  = h;
        int m = s+(e-s)/2;
        int pilot  = nums[m];

        while (s<=e){
            while (nums[s]<pilot){
                s++;
            }
            while (nums[e]>pilot){
                e--;
            }

            if(s<=e){
                int temp = nums[s];
                nums[s]= nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        sort(nums, l, e);
        sort(nums, s, h);
    }


}