// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int max = dp[0];
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max; 
    }
}
