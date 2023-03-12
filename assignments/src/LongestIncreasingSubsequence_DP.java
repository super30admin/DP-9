// Approach: Memoization: bottom up DP. choose / not choose pattern
// Time: O(n^2)
// Space: O(n)

import java.util.Arrays;

class LongestIncreasingSubsequence_DP {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int result = 1;
        for (int i = 1; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}