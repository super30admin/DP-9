class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sanity check
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0){
            return 0;
        }
        //sorting the input based on the first index
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        //creating and initializing dp array with 1
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        int max = dp[0];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                // if both length and width satisfies the condition the update dp value
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            //keeping track of max value
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
//Time Complexity: O(nlogn)
//Space Complexity: O(n)