// space complexity: o(n)
// time complexity: o(n^2)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
         int[] dp = new int[nums.length];
               
    int res = 1;
    for(int i=0; i<nums.length;i++){
        dp[i]=1;
        for(int j=0; j<i; j++){
            if(nums[j]<nums[i]){
                dp[i]=Math.max(dp[j],dp[j]+1);
                res=Math.max(dp[i],res);
            }
        }
    }
    return res;
    }   
}