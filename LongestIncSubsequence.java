// Time Complexity : O(n*2)
// Space Complexity : O(n) for dp array 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//initialize a dp array with length as nums and fill it with 1 as each element makes a valid subsequence with itself
//take a global max to keep track of max subseq length
//our i pointer helps to move the current position and j pointer to check valid subsequences upto that i.
//at each i, we check for all j upto that i in nums , if they are greater than previous element and keep track of count in dp array
//update max after each ith iteration
//return max

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
}