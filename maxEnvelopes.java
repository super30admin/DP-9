// Time Complexity : O(n*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        //sort the array on the basis of width
        Arrays.sort(envelopes, (a, b) ->  (a[0]-b[0]));

        int   n  = envelopes.length;
        int[] dp = new int[n];

        // Use LIS techinque
        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;

            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                    && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);    
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;  
    }
}
