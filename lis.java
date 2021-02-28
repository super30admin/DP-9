// Time, space - O(N^2), O(N)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j])          {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max=Math.max(max, dp[i]);
                }       
            }
        }
        return max;
    }
}
