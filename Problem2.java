// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Passed Leetcode

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int[] dp = new int[envelopes.length];
        int result = 0;
        
        Arrays.sort(envelopes,new Comparator<int[]>(){
            
            public int compare(final int[] lhs,int[] rhs) {
                return Integer.compare(lhs[0], rhs[0]);
            }
        });
        
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;

            for (int j = 0; j <= i; j++) {
                
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                
            }
            
            result = Math.max(dp[i], result);
        }
        return result;
    }
}