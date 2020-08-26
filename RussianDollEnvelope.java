// Time Complexity : O(wlogw+h^2) w=width, h=height
// Space Complexity : O(h) for dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach
// Sort the envelopes in width or height. Then we get to find LCS of the other one.
// For finding LCS, take a dp array for each element, find lcs from start and see if max length lcs that
// needs to be kept. Rent the length as no of envelopes required

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int[] dp = new int[envelopes.length];
        int max = 1;
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b) -> a[0]-b[0]);
        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<i;j++) {
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}