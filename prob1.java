// Time Complexity : O(n^2)  
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int dfs(int[] nums,int prev,int index,int[][] dp){
        if(index>=nums.length){
            return 0;
        }
        if (dp[index][prev+1]!= -1) return dp[index][prev+1];
        int notTake=dfs(nums,prev,index+1,dp);
        int take=0;
        if(prev==-1||nums[prev]<nums[index]){
            take=1+dfs(nums,index,index+1,dp);
        }
        
        return dp[index][prev+1]=Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] nums) {
        int [][] dp= new int[nums.length][nums.length+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return dfs(nums,-1,0,dp);
    }
}//TC:O(n^2), SC:O(n^2)