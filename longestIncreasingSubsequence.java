// Time Complexity : O(N^2), using nested for loop. Worst case j will be N-2
// Space Complexity : O(N) using dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//The approach is to compare whether the current element is greater than all of it's previous element. If yes, and if it's count is less than or equal to the previous count, then increment it by 1.
//Else do nothing.
//Keep track of max count.

class Solution {
    public int lengthOfLIS(int[] nums) {
        //base check
        if(nums == null || nums.length == 0) return 0; 
       //initialize dp array
        int[] dp = new int[nums.length];
        //by default every number is a LIS of itself so assign 1 to them
        dp[0] = 1;
        
        //count of maximum length
        int maxLength = 1;
        
        for(int i=1; i<dp.length; i++){
        	//by default every number is a LIS of itself so assign 1 to them
            dp[i] = 1;
            //for every element(i) you need to go back to to (i-1) element(say, j) and check whether it is greater than j.
            for(int j =0; j<i; j++){
              if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = 1 + dp[j];
                    maxLength = Math.max(maxLength, dp[i]);
                }  
            }            
        }
        
        return maxLength;
    }
}


