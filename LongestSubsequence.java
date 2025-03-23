// Time Complexity :O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];

        Arrays.fill(dp,1);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;

        
    }
}