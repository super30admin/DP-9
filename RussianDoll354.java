class Solution {
    
    // Approach: DP
    //     Sorting based on width, then Longest Increasing Subsequnce
    // TC:  O(n)
    // SC:  O(n)
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
            return 0;
        
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        
        int[] dp = new int[envelopes.length];
        int max = 1;
        
        // Arrays.fill(dp, 1);
        for(int i = 0; i < envelopes.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] != envelopes[i][0]){
                     dp[i] = Math.max(dp[i], 1+dp[j]);
                     max = Math.max(max, dp[i]);
                }       
            }
        }
        return max;
    }
}