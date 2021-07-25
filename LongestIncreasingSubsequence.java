package DP9;

import java.util.Arrays;

/*S30 FAANG Problem #153 {Medium} - https://www.youtube.com/watch?v=qAxa3f14SAE


Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]

Output: 4 

Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Source Link: https://leetcode.com/problems/longest-increasing-subsequence/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n * n) and O(nlogn) with binary search
    space complexity: o(n)
    Did this code run successfully in leetcode : yes
    problems faces : no*/
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;

        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    
    public int lengthOfLISBinary(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;

        int[] arr = new int[n]; // effective sub sequence array
        arr[0] = nums[0];
        int len = 1;
        
        for (int i = 1; i < nums.length; i++) {
            
            if(nums[i] > arr[len-1] )
            {
                arr[len] = nums[i];
                len++;
            }
            else {
                
              int bsIndex =  binarySearchIndex(arr,0,len-1,nums[i]);
              arr[bsIndex] = nums[i];
            }
            
        }
        return len;
    }
    
    private int binarySearchIndex(int[] arr, int low, int high,int target)
    {
        
        while(low<=high)
        {       
            int mid = low +( high-low)/2;
            if(arr[mid] == target) return mid; 
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
            
        }
        return low;
    }
}
