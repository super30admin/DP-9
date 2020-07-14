/**
 * Time Complexity - O(N^2)
 * Space Complexty - O(N)
 * This code is working fine on leetcode
 * This problem is similar to Longest Increasing subsequence - considering width and height
 */

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length==0)
            return 0;

        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] - b[0]);

        int[] dp = new int[envelopes.length];
        int ans = 0;
        for(int i=0; i<envelopes.length;i++){
            int maxValue = 0;
            for(int j=0; j <i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    maxValue = Math.max(maxValue,dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}