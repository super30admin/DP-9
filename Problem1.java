// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Passed Leetcode

class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
        
    }
}