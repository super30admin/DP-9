// Time Complexity : O(n^2) where n is the length of the array nums
// Space Complexity : O(n) where n is the length of the array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// iter i thru dp thru 1 to end
    // iter j thru 0 to i-1
        // if curr num (nums[i]) > prev num (nums[j]) 
            // we can add this to our increasing sequence till now, so take max till now of dp[j] values
            // and also keep track of max till now, so ans = max(ans, dp[i])
// return ans

class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}