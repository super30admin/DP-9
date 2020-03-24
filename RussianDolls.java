//TC : O(n log n + n2) --> O(n2) , n is size of envelopes array
//SC : O(n) , n is size of envelopes array
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes.length == 0 || envelopes == null)
            return 0;
        
        int dp[] = new int[envelopes.length];
        
        Arrays.sort(envelopes,(int[] a, int[] b)->a[0]-b[0]);
            
       System.out.println(Arrays.deepToString(envelopes));
        //keep max at 1
        int max = 1;
        Arrays.fill(dp,1);
        for(int i=1;i<envelopes.length;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
                max = Math.max(max,dp[i]);
            }
        }
            
        return max;
        
    }
}