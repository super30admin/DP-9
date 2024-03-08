// https://leetcode.com/problems/russian-doll-envelopes/

// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // Sort based on width, if widths are same, sort based on height in
                // descending order
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initially, each envelope can be nested as itself

        int maxCount = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    // If both width and height of the current envelope are
                    // greater than the j-th envelope,
                    // then it can be nested inside j-th envelope
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxCount = Math.max(maxCount, dp[i]);
                }
            }
        }
        return maxCount;
    }
}
