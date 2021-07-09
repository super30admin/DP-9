/*
Desc : Here we maintain a dp array, where we store the number of adjacent longest increasing subsequence count.
Time Complexity : O(n^2)
Space Complexity : O(n)
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp,1);
        for(int i = 1; i<nums.length ; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] <nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
