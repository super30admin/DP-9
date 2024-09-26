
public class Solution {
    public int lengthOfLIS(int[] nums) {
  
        if (nums.length == 0) return 0;
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n]; // Create a DP array of size n.
  
     for (int i = 0; i < n; i++) 
     {
        dp[i] = 1; // set DP[i] as 1 first.
    
    for (int j = 0; j < i; j++)     // Run the second loop from start to the current i value to find LIS.
    {
         if (nums[i] > nums[j]) 
        {
             if(dp[j]+1>dp[i])
            dp[i] = dp[j] + 1;
        }
    }
    max = Math.max(max, dp[i]); // get the length of LIS.
  }
  
  return max;
}
}
