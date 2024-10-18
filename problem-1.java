// Time Complexity :O(n²)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;  // Edge case: if the array is empty
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Initialize each element to 1
        int max = 1;  // Store the length of the longest increasing subsequence
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {  // Check if the current number is larger
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // Update dp array
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}