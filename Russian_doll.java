// Time Complexity :O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Approach : sort envelopes 2-d array and apply LengthofLIS approach to get the result.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        int envLen = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] dp = new int[envLen];
        int result = 1;
        for(int i = 0; i< envLen; i++)
            dp[i] = 1;
        
        for(int i = 1; i < dp.length; i++){
            int maxLen = 0;
            for(int j = 0; j< i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    maxLen = Math.max(maxLen, dp[j]);
            }
            dp[i] += maxLen;
            result = Math.max(result, dp[i]);
        }
    return result;
    }
}