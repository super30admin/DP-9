Time Complexity = O(n*n)
Space Complexity = O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}