// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Input length is 1 <= nums.length <= 2500. So it works.

import java.util.Arrays;

public class LongestIncreasingSubSeqUsingDP {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int result = dp[0] ;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    result = Math.max(result,dp[i]);
                }
            }
        }
        return result;
    }
}