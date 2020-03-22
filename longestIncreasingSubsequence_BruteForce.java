// Time Complexity : O(n^2) where n is the length of the array nums
// Space Complexity : O(n) where n is the length of the array nums
// Did this code successfully run on Leetcode : No, TLE
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class longestIncreasingSubsequence_BruteForce {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, Integer.MIN_VALUE, 0);
    }
    private int helper(int[] nums, int idx, int prev, int maxLen) {
        // base case
        if (idx >= nums.length) return maxLen;
        // logic
        int choose = 0;
        if (nums[idx] > prev) {
            choose = helper(nums, idx + 1, nums[idx], maxLen + 1);    
        }
        int notChoose = helper(nums, idx + 1, prev, maxLen);
        return Math.max(choose, notChoose);
    } 
}