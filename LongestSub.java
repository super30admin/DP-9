import java.util.Arrays;

// Time Complexity :O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Pointer i is used to iterate over the entire array once.
 * 2 - Pointer j is used to form possible combinations with the pointer i and the elements before it.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null)
        {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        
        Arrays.fill(dp,1);
        
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}