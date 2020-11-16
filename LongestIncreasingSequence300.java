class Solution {
    // Approach : DP
    //      Calculating the number of incrreasing subsequences at every index from 0
    //          - Each element itself is subsequence => 1
    //          - max => to keep track of max length ( 1 is the min possible and not MIN_VALUE)
    //          [10, 9, 2, 5, 3, 7, 101, 18]
    //          [ 1, 1, 1, 2, 2, 3,   4,  4]
    
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        int max = 1;
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;              // Every number itself is a subsequence ==> 1
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}