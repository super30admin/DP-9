// Time Complexity :O(N^2)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Many test cases failed initially


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length == 1) return 1;

        int[] dp = new int[nums.length];
        int index =0;
        int result = 0;

        for(int i=0;i<nums.length;i++){
            index = i;
            // dp[index]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[index]<nums[j]){
                    dp[j] = dp[index]+1;
                    result = Math.max(result,dp[j]);
                    index = j;
                }
              else if(nums[i]<nums[j]){
                   dp[j] = dp[i]+1;
                    result = Math.max(result,dp[j]);
                    if(nums[j]>nums[index])index = j;
                    
                }
              
            }
        }
        return result+1;
    }
}