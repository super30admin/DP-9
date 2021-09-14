// Time Complexity : O(n^2), n -> Number of envelopes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

		int n = envelopes.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int max = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		RussianDollEnvelopes obj = new RussianDollEnvelopes();
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

		System.out.println("Maximum number of envelopes we can Russian Doll: " + obj.maxEnvelopes(envelopes));
	}

}
