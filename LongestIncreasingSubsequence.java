// Time Complexity : O(2^n) n-> no of elements
// Space Complexity : O(n), recursive stack space
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : No

// Approach 1 : Brute force, recursive approach
// Here we have 2 choices at every step, whether to choose the current element or not choose the current element.
// We can choose the current element only if it is greater than the previous element.
// The result will be the maximum count of the two choices made.
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        // edge case
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, -1);
    }
    
    private int helper(int[] nums, int index, int prev) { // [10,9,2,5,3,7,101,18]
        // base case
        if(index >= nums.length)
            return 0;
        
        // logic
        int count1 = 0, count2 = 0;
        // do not choose current element
        count1 = helper(nums, index+1, prev);
        
        // choose current element
        // choose only when current element is greater than previously chosen element
        if(prev == -1 || nums[index] > nums[prev]) { 
            count2 = 1 + helper(nums, index+1, index);
        }
        return Math.max(count1, count2);
    }
}
*/

// Time Complexity : O(n^2) n-> no of elements
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 2 : Recursive approach with memoization
// Here we have 2 choices at every step, whether to choose the current element or not choose the current element.
// We can choose the current element only if it is greater than the previous element.
// The result will be the maximum count of the two choices made.
// if a certain combination of previous index and current index has been explored earlier, then no need to explore it again. Its result can be directly returned from the memoized array.
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        // edge cases
        if(nums == null) {
            return 0;
        }
        if(nums.length <= 1) {
            return nums.length;
        }
        
        // memo table, 2-D because two variables-> prev indx and current index
        int[][] memo = new int[nums.length+1][nums.length];
        
        return helper(nums, 0, -1, memo);
    }
    
    private int helper(int[] nums, int index, int prev, int[][] memo) { 
        // base case
        if(index >= nums.length)
            return 0;
        
        // check in memo table
        // need to offset prev index because its starting with -1
        if(memo[prev+1][index] != 0)
            return memo[prev+1][index];
        
        // logic
        int count1 = 0, count2 = 0;
        // do not choose current element
        count1 = helper(nums, index+1, prev, memo);
        
        // choose current element
        // choose only when current element is greater than previously chosen element
        if(prev == -1 || nums[index] > nums[prev]) { 
            count2 = 1 + helper(nums, index+1, index, memo);
        }
        memo[prev+1][index] = Math.max(count1, count2);
        return memo[prev+1][index];
    }
}
*/

// Time Complexity : O(n^2) n-> no of elements
// Space Complexity : O(n), strictly it is twice the number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 3: Tabulation
// On observing the memoized approach, one can easily simplify and do it iteratively using tabulation approach.
// Memoized version considers indices as the changing factors which can be tabulated for deducing the formula. Since both the changing variables are indices, it can be represented as a single 1-D array

class Solution {
    public int lengthOfLIS(int[] nums) {
        // edge cases
        if(nums == null) {
            return 0;
        }
        if(nums.length <= 1) {
            return nums.length;
        }
        
        // dp table, 1-D because two variables-> prev indx and current index
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // by default each element will form a subsequence of length 1
        int max = 0;
        for(int curr = 0; curr < nums.length; curr++) {
            for(int prev = 0; prev < curr; prev++) {
                if(nums[curr] > nums[prev]) {
                        dp[curr] = Math.max(dp[curr], dp[prev]+1);
                }
            }
            max = Math.max(max, dp[curr]);
        }
        return max;
    }
}
