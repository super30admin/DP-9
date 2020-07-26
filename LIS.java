//time o(n pow 2)
//space o(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    int val = dp[j] + 1;
                    dp[i] = Math.max(dp[i], val);
                }
            }
        }
        
        int res =0;
        for(int i=0; i<nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}