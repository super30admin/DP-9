// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0 || envelopes == null) return 0;
        Arrays.sort(envelopes,(a,b) -> a[0]-b[0]);
        int[] dp = new int[envelopes.length];
        dp[0] =1;
        int res = 1;
        for(int i=1;i<envelopes.length;i++){
            int max =0;
            for(int j=0;j<i;j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    max = Math.max(dp[j],max);
            }
            dp[i] = max+1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
