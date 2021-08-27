// Time Complexity : O(n^2)
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int ans = dp[i];
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                   ans = Math.max(ans, dp[i]+dp[j]);
                }
            }
            dp[i] = ans;
            max = Math.max(max, ans);
        }
        return max;
    }
}
