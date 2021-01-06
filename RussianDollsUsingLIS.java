import java.util.Arrays;

public class RussianDollsUsingLIS {
	public int maxEnvelopes(int[][] envelopes) {

		if (envelopes == null || envelopes.length == 0)
			return 0;

		// logic
		// 1) sort
		// 2) Apply LIS
		// sort
		Arrays.sort(envelopes, (a, b) -> a[0] - b[0]); // sorted envelopes according to the 0 Indices
		int max = 1;
		int[] dp = new int[envelopes.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					max = Math.max(max, dp[i]);

				}
			}
		}
		return max;

	}
}
