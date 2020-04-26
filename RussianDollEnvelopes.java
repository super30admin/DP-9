Time Complexity = O(n*n)
Space Complexity = O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)return 0;
        
       Arrays.sort(envelopes,(int[] a, int[] b)-> (a[0] - b[0]));
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        
        int maxLen = 0;
        for(int i = 0; i < envelopes.length; i++){
            for(int j = i-1; j>=0; j--){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}