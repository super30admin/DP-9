/*
 * TC = O(N^2)
 * SC = O(N)
 * 
 * Approach: At every index i, we iterate from 0 to i-1 and check if the element at i is greater than j or not.
 * If it is greater, we increment the count and update the value at dp[i] with the maximum value
 */


import java.util.*;
public class LongestIncreasingSubsequence
{   

    public static int Length(int[] nums)
    {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int max = 1;

        for(int i =1;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }

        return max;
    }

    public static void main(String args[])
    {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(Length(nums));
    }
}