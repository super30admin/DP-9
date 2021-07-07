// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max  = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        
        return max;
    }
}