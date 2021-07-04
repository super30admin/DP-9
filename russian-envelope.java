/*

https://leetcode.com/problems/russian-doll-envelopes/

Time Complexity: 0(N2+NlogN)
Space Complexity: 0(N)


- Sort the envelopes based on increasing widths.
- Then the problem becomes similar to longest increasing subsequence based on the heights.
- But in comparison you need to have a stricter condition, so we again compare widths and compare heights to update the dp array.

Visit [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int n = envelopes.length;
        if(n==0){
            return 0;
        }
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]);
        int retVal = 1;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        for(int i=1;i<n;++i){
            int maxSubSeq = 0;
            for(int j=0;j<i;++j){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    maxSubSeq = Math.max(maxSubSeq,dp[j]);
                }
            }
            
            dp[i] = dp[i] + maxSubSeq;
            retVal = Math.max(retVal,dp[i]);
        }
        
        return retVal;
        
        
    }
}