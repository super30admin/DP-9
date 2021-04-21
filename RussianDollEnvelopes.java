// Time Complexity : O(N * N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We sort the envelopes array in ascending order of widths
// Create a dp array of length envelopes.length and fill with 1s
// Initialize max variable to 1
// As we iterate through the envelopes array, iterate through each of the preceeding elements of envelopes[i]
// If envelopes[i][1] > envelopes[j][1] and envelopes[i][0] > envelopes[j][0], update dp[i] and max
// return max

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        
        for(int i = 1; i < envelopes.length; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}