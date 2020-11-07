    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/russian-doll-envelopes/
    Time Complexity for operators : o(n^2) .. n is the length of the ENVELOPS
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 

    */  

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        int max = 1;
        int dp[] = new int[envelopes.length];
        
        Arrays.fill(dp,1);
        
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        
        for(int i=1;i<envelopes.length;i++){
            for(int j = 0; j<i;j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        
        return max;
    }
}