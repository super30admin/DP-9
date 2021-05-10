// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result =1;
        for(int i=0;i<nums.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j])
                    max = Math.max(max,dp[j]);
            }
            dp[i] = max+1;
            result = Math.max(dp[i],result);
        }
        return result;
    }
}
