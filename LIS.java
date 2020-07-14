// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length ==1) return 1;
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int i =1;
        int j = 0;
        while(i<nums.length)
        {
            if(nums[j]<nums[i])
            {
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
            j++;
            if(j==i)
            {
                i++;
                j=0;
            }
        }
        int max =0;
        for(int a:dp) max = Math.max(max,a);
        return max;
    }
}