// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed from class

// Your code here along with comments explaining your approach
// dp[i] indicates max subsequence length till that index i
// we start by filling from idx 1, dp[i] = Math.max(dp[i], dp[j]+1), for j from 0 till i-1
// result is max over dp[]

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int result = 1;
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);            
        }
        
        return result;
    }
}