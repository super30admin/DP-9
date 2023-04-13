import java.util.Arrays;
//Time Complexity : O(N^2)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Using dp, fill it with 1 initially. At each num, check how many of the
 * previous elements are less than it and store it in dp index. finally use a
 * max variable to get the max value out of dp array and return it.
 *
 */
class Solution {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		for (int i = 0; i < n; i++)
			max = Math.max(dp[i], max);
		return max;
	}
}
