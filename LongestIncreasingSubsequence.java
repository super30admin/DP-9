/****
 * Computes Longest Increasing Subsequence using O(n^2) dynamic programming.
 * dp[i] stores the length of the LIS ending at index i by checking all previous j < i.
 * Time Complexity: O(n^2), Space Complexity: O(n)
 */
package DP-9;

public class LongestIncreasingSubsequence {
        public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
    
}
