/*Time Complexity: O(M*N)

Space Complexity: O(M*N)

Did this code successfully run on Leetcode : Yes

Approach: Tabulation - Bottom up

Prob: 300. Longest Increasing Subsequence
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Tabulation
        int n = nums.length;
        int [][] dp = new int[n+1][n+1]; 
        for(int ind = n-1; ind >= 0; ind--){
            for(int prev = ind-1; prev >= -1; prev--){
                int len = 0 + dp[ind + 1][prev + 1];
                if(prev == -1 || nums[ind] > nums[prev]){
                    len = Math.max(len, 1 + dp[ind+1][ind+1]);
                }
                dp[ind][prev+1] = len;
            }
        }
        return dp[0][0];
    }
}