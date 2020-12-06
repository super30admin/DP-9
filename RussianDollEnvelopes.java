// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed from class

// Your code here along with comments explaining your approach
// Similar to LIS, we first have to sort the evelopes array by width, then its LIS on heights


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0)
            return 0;
        
        Arrays.sort(envelopes, (a,b)->a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        int result = 1;
        for(int i=1; i<envelopes.length; i++){
            for(int j=0; j<i; j++){
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}