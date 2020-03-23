//Time complexity is O(N^2)
//Space complexity is O(N)
//This solution is submitted on leetcode

import java.util.Arrays;

public class BigN152LongestSubsequenceDP {
	class Solution {
		public int lengthOfLIS(int[] nums) {
			// edge case
			if (nums == null || nums.length == 0)
				return 0;
			int[] dp = new int[nums.length];
			Arrays.fill(dp, 1);
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[i] > nums[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			int max = 0;
			for (int i = 0; i < dp.length; i++) {
				max = Math.max(max, dp[i]);
			}
			return max;
		}
	}
}