// Time Complexity : O(n^2) where n is the length of the array envelopes
// Space Complexity : O(n) where n is the length of the array envelopes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sort the 2d array envelopes on basis of height or width, then this problem becomes LIS

class russianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] - b[0]);
        // System.out.print(Arrays.deepToString(envelopes));
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}