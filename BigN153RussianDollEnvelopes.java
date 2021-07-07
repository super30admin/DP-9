// Time complexity is O(N^2)
// Space complexity is O(N)
// This solution is submitted on leetcode

import java.util.Arrays;

public class BigN153RussianDollEnvelopes {
	class Solution {
		public int maxEnvelopes(int[][] envelopes) {
			// edge case
			if (envelopes == null || envelopes.length == 0)
				return 0;
			int len = envelopes.length;
			int[] dp = new int[len];
			Arrays.fill(dp, 1);
			int max = 1;
			Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] - b[0]);
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < i; j++) {
					if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						max = Math.max(max, dp[i]);
					}
				}
			}
			return max;
		}
	}
}