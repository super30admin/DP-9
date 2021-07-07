// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, Integer.MIN_VALUE, 0);
    }

    private int helper(int[] nums, int prev, int index){
        if(index == nums.length){
            return 0;
        }

        int taken = 0;
        if(nums[index] > prev){
            taken = 1 + helper(nums, nums[index], index + 1);
        }

        int notTaken = helper(nums, prev, index + 1);
        return Math.max(taken, notTaken);
    }
}
