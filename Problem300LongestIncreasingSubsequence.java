/**
 * Time Complexity - O(N^2)
 * Space Complexity - O(N)
 * This code is working fine on leetcode
 */

class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length==0)
            return 0;

        int maxAns = 0;

        int[] dp = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int maxValue = 0;
            for(int j=0; j < i; j++){
                if(nums[j] < nums[i]){
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;
    }
}