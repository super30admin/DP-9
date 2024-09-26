//Time complexity : O(n^2)- have 2 for loops, outer loop iterates over the entire array once, whereas the inner loop iterates starting from index 0 until the ith index
//Space Complexity: O(n)- defined one array of given array length
// Did this code successfully run on Leetcode :Yes
//Runtime: 10 ms, faster than 42.14% of Java online submissions for Longest Increasing Subsequence.
//Memory Usage: 36.8 MB, less than 56.00% of Java online submissions for Longest Increasing Subsequence.
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach-> Problem solved using DP

import java.io.*;
import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len= nums.length;
        int max=1;
        if (len ==0) return 0;
        int[] dp= new int[len];
        Arrays.fill(dp,1);
       // System.out.println(Arrays.toString(dp));
        for(int i=1; i<nums.length;i++){
           for(int j=0; j<i; j++){
               if(nums[j]<nums[i]){
                   dp[i]= Math.max(dp[i], 1+dp[j]);
                   max=Math.max(max, dp[i]);
               } 
           }
        }
        //System.out.println(Arrays.toString(dp));
        return max;   
    }
}
