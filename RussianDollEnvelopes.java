// Time Complexity : O(m * n) --> where m and n are the length of input 2-D matrix
// Space Complexity : O(m)
// Did this code successfully run on Leetcode (354): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // edge case
        if (envelopes == null || envelopes.length == 0) return 0;
        
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}