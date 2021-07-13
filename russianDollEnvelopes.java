//Time Complexity : O(nlogn)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a,b)->(a[0] - b[0]));
        
        int max = 1;
        int[] dp = new int[envelopes.length];
        
        Arrays.fill(dp,1);
        
        for(int i = 1; i < envelopes.length; i ++){
            
            for(int j = 0; j < i; j ++){
                
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    
                    dp[i] = Math.max(dp[i],dp[j]+ 1);
                }
            }
            
             max = Math.max(max,dp[i]);
        }
        return max;
    }
}