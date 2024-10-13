//TC: O(n^2)
//SC: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;
        
        // Initialize dp array with 1 because each element is a subsequence of length 1
        Arrays.fill(dp, 1);
        
        // For each element, find the LIS ending at that element
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Track the overall maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}
