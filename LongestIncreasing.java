class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0; 
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}