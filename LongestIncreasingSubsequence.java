// Time Complexity : O(n*n) n is the number of elements in nums array
// Space Complexity : O(n) n is the number of elements in the nums array 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int max = Integer.MIN_VALUE;
        
        //initialize dp array
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp,1);
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j]){  //if we get the increasing order
                    //we increase the value of length by 1 and choose which is the maximum as we want longest increasing subsequence
                    dp[i] = Math.max(dp[i] , dp[j] + 1);    
                    max = Math.max(max, dp[i]);
                }
            }
        }
        //if there is one element in the given array then we need to check whether the max has the value of 
        //minimum value of integer else we return what we have maximum length till now.
        return max == Integer.MIN_VALUE? 1 : max;
    }
}
