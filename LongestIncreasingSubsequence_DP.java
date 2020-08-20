// Time Complexity : O(n^2) --> where n is the length of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (300): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) return 0;
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}