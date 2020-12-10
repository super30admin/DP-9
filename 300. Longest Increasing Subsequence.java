class Solution {//Time of O(N^2) and space of O(N)
    public int lengthOfLIS(int[] nums) {
       
        //Base case 
        if(nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        
        for(int i=1 ; i<nums.length ; i++){
            int maxval = 0;
            for(int j= 0; j<i ; j++){
                if(nums[i]>nums[j]){
                    maxval = Math.max(maxval,dp[j]);
                }
                dp[i] = 1 + maxval;
                result = Math.max(result,dp[i]);
            }
        }
        return result;
    }
}