// Time Complexity : 1 - O(n^2), 2 - O(nlogn)
// Space Complexity : 1 - O(n), 2 - O(n)

// DP Solution
/*class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i<nums.length; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i: dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}*/

// Binary Search Solution
class Solution {
  public int lengthOfLIS(int[] nums) {
    if(nums.length == 0 || nums == null) return 0;
    int n = nums.length;
    int[] result = new int[n];
    result[0] = nums[0];
    int len = 1;

    for(int i = 1; i<n; i++) {
      if(nums[i] > result[len-1]) {
        result[len] = nums[i];
        len++;
      } else {
        int index = binarySearch(result, 0, len-1, nums[i]);
        result[index] = nums[i];
      }
    }
    return len;
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
    while(left <= right) {
      int mid = left + (right - left)/2;
      if(nums[mid] == target) return mid;
      else if(nums[mid] > target) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }
}