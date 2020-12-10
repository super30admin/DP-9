class Solution {//Time of O(N^2+ N logN) and space O(N)
    public int maxEnvelopes(int[][] envelopes) {
        
        int len = envelopes.length;
        //Base case 
        if(len==0) return 0;
        
        Arrays.sort(envelopes, (a,b)-> Integer.compare(a[0],b[0]));//Compare width
        int[] dp = new int[len];
       // dp[0] = 1;
       Arrays.fill(dp,1);
        int result = 1;
        
        for(int i =1; i<len ; i++){
           // int maxlen = 0;
            for(int j=0 ; j<i ;j++){
                if(envelopes[i][0]> envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                 //  maxlen = Math.max(maxlen,dp[j]);
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                //dp[i] = 1 + maxlen;
                result = Math.max(result,dp[i]);
            }
        }
        return result;
    }
}