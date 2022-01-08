//354 Russian Doll envelopes
// Time - O(n2)
// Space - O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] - b[0];
        });
            
        int[] dp = new int[envelopes.length];
        
        for(int i = 0 ;i < dp.length; i++){
            dp[i] = 1;
        }
        
        
        for(int i = 1; i < envelopes.length; i++){
            
            for(int j = 0; j < i; j++){
                
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length;i++){
            
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}