


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length ==0){
            return 0;
        }
        
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        
        int [] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        
        int retval =1;
        
        for(int i=1; i< envelopes.length; i++){
            int maxsub = 0;
            for(int j=0; j<i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    maxsub = Math.max(maxsub,dp[j]);
                }
            }
            
            dp[i]  = dp[i] + maxsub;
            retval = Math.max(retval,dp[i]);
        }
        
        return retval;
    }
}
