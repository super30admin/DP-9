//Time Complexity-O(n*m)
//Space Complexity-O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums==null)
        {
            return 0;
        }
        int max=1;
        int[]dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}