    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/longest-increasing-subsequence/
    Time Complexity for operators : o(n^2) .. n is the length of the ENVELOPS
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 

    */  

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 1;
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1;i < nums.length; i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}