class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    if(max<dp[i]){
                        max = dp[i];
                    }
                }
            
            }
            
        }
        return max;
        
    }
}