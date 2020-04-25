// Time Complexity : O(n^2) as we check from each point backward looking for any lesser elements available.
// Space Complexity : O(n) as we store a DP array for increasing sequence so far.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Our goal is to get maximum number of sequence which are in increasing order

// Appraoch
// Initially all the individual number is a sequence of 1 element.
// From each point trace back if the number behind is lesser. If so then include that in the increasing sequnec of current number
// if not trace back and check until reach 0th index
// Choose the maximum sequence of numbers can be extended at each point.
// Keep track of MAX_SEQ for each index and return the maximum value

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] resut_dp = new int[n];
        // Initially all the single number has LIS value 1.
        Arrays.fill(resut_dp, 1);
        int maxLen = 1;
        
        for(int i=1; i< n; i++){                // Start from 1 till end of array
            for(int j = i; j >=0; j--){         // From i-th index trace back till 0 to see if there is any number less than current number
                if(nums[j] < nums[i]){
                    resut_dp[i]  = Math.max(resut_dp[i], resut_dp[j] + 1); // Keep track of max no. of seq possible for each elements.
                }
                maxLen = Math.max(maxLen, resut_dp[i]);  // Keep track of max sequece occured so far.
            }
        }
        
        return maxLen;
    }
}
