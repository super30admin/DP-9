// Time Complexity : O(N logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We create a dp array of size nums.length and set dp[0] to nums[0]
// Intialize len variable to 1
// As we iterate through the array, if nums[i] > dp[len - 1], we update dp[len] to nums[i] and increment len
// else we find the correct index for nums[i] using binary search and update dp[index] to nums[i]
// Return len 

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            }
            else
            {
                int index = binarySearch(dp, 0, len - 1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] dp, int low, int high, int target) {

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(target == dp[mid]) {
                return mid;
            }
            else if(target < dp[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}