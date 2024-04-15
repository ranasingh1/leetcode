class Solution {
  public int threeSumClosest(int[] nums, int target) {
    sort(nums, 0, nums.length - 1);

    // Handle case with all positive elements and positive target
    if (nums[0] >= 0 && target > nums[nums.length - 1] * 3) {
      return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
    }

    int minDiff = Integer.MAX_VALUE;
    int closestSum = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high) {
        int sum = nums[i] + nums[low] + nums[high];
        int diff = Math.abs(sum - target);

        if (diff < minDiff) {
          minDiff = diff;
          closestSum = sum;
        }

        if (sum < target) {
          low++;
        } else {
          high--;
        }
      }
    }

    return closestSum;
  }

  public static void sort(int[] nums, int l, int h) {
    if (l >= h) {
      return;
    }
    int s = l;
    int e = h;
    int m = s + (e - s) / 2;
    int pilot = nums[m];

    while (s <= e) {
      while (nums[s] < pilot) {
        s++;
      }
      while (nums[e] > pilot) {
        e--;
      }

      if (s <= e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
        s++;
        e--;
      }
    }
    sort(nums, l, e);
    sort(nums, s, h);
  }
}
