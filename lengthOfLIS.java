// Time Complexity :O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Take a dp array with 1 s each, initially.  Take base case result = 1.
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int result = 1;
        for(int i = 0; i< nums.length; i++)
            dp[i] = 1;
        //In below loops i goes from 1 to n-1 and j from 0 to i-1. Every time the condition is correct,
        // maxLen is updated, which is 0 initially.This is because dp[j] = 1 initially whereas maxlen = 0
        // so maxLen will be updated with dp[j] first time and so on. Then we add maxLen to dp[i].
        // For eg.
        //10,9,2,5,3,7,101,10 dp array will be
        //1,1,1,2,2,3,4,4        
        for(int i = 1; i < dp.length; i++){
            int maxLen = 0;
            for(int j = 0; j< i; j++){
                if(nums[i] > nums[j])
                    maxLen = Math.max(maxLen, dp[j]);
            }
            dp[i] += maxLen;
            result = Math.max(result, dp[i]);
        }
    return result;
    }
}