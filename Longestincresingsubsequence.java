// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp=new int[nums.length]; 
        int maxcount=1;
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int maxval=0;
            for(int j=0;j<i;j++){ //Finding all the elements smaller then current.
                if(nums[i]>nums[j]){
                    maxval=Math.max(maxval,dp[j]);
                }
            }
            dp[i]=maxval+1;
            maxcount=Math.max(maxcount, dp[i]);
        }

        return maxcount;
        
    }
}