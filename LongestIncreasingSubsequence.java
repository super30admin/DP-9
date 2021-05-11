class LongestIncreasingSubsequence {
    
    // Time Complexity: O(n^2)  (where n -> length of nums array)
    // Space Complexity: O(n)
    
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxVal = 1;
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}