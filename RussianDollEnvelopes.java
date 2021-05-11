class RussianDollEnvelopes {
    
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        int n = envelopes.length;
        
        // Sort the array based on increasing order of widht
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        
        // LIS Concept:
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxVal = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}