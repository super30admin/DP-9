import java.util.Arrays;

/*
Solution to LeetCode 300 - Longest Increasing Subsequence
Approach:
- Dynamic Programming: dp[i] = length of the longest increasing subsequence ending at index i.
- For each index i, iterate j from 0..i-1 and update dp[i] when nums[i] > nums[j].
- Keep track of the maximum dp[i].

Time Complexity: O(n^2)
Space Complexity: O(n)
LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/
*/
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
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

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

}
