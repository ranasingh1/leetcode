class Solution {
    public int thirdMax(int[] nums) {
     if(nums.length==1){
        return nums[0];
     }else if(nums.length ==2){
                 int last = nums.length-1;
            int maxIndex = getMaxIndex(nums, 0 , last);
           return nums[maxIndex];
     }
          for (int i = 0; i < nums.length ; i++) {

         int last = nums.length-i-1;
         
            int maxIndex = getMaxIndex(nums, 0 , last);
             swap(nums, maxIndex, last);
            
        }     
        int k=nums[nums.length-1];
        int count = 1;

            for(int i=nums.length-1;i>=0;i--){

                if(i<nums.length-1 && nums[i] != nums[i+1]){
                    k=nums[i];
                    count++;
                    if(count>=3){
                        return k;
                    }
                }
            }

        return nums[nums.length-1];
    }
public static  void  swap(int [] arr , int first, int second){
          int temp = arr[first];
          arr[first] = arr[second];
          arr[second] = temp;
      }
    public  static int getMaxIndex(int []arr, int start, int end){
        
           int max = start;
          for (int i = start; i <=end ; i++) {
              if(arr[i]>arr[max]){
                  max = i;
              }

          }
           return max;

      }
}
