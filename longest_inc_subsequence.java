//TC: O(n^2)
//SC: O(n)
//Approach: Everytime I encounter an increasing substring, I try to increment the present position in DP array by taking maximum of all the preceeding values

class Solution {
    public int lengthOfLIS(int[] nums) {
        //Edge case
        if(nums.length<=1) return nums.length;
        
        //Logic
        int maxLength=0;
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp,1);
        
        for(int i=1;i<nums.length;i++){
            int maxSub=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    maxSub = Math.max(maxSub,dp[j]);
            } 
            if(maxSub!=Integer.MIN_VALUE)
                dp[i]=dp[i]+maxSub;
            
            maxLength = Math.max(dp[i],maxLength);
        }
        return maxLength;
    }
}

 
