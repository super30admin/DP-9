// Time Complexity : The time complexity is O(n2) where n is the length of array
// Space Complexity : The space complexity is O(n) where n is the length of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;i++){
            //find numbers less than the current number
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
            }
        }

        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
