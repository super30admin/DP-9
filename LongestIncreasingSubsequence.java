// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int le = 1;
        
        for(int i = 1; i < n; i++){
           if(nums[i] > dp[le - 1]){
               dp[le] = nums[i];
               le++;
           } else {
               int bsIndex = binarySearch(dp, 0, le, nums[i]);
               dp[bsIndex] = nums[i];
           }
        }
        return le;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target > arr[mid])
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }
}