package com.recommender;

import java.util.Arrays;

//Time Complexity : O(N^2) for DP
//Space Complexity : O(N^2) for DP
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/**
 * 
 * he simplest approach is to try to find all increasing subsequences and then
 * returning the maximum length of longest increasing subsequence. In order to
 * do this, we make use of a recursive function \text{lengthofLIS}lengthofLIS
 * which returns the length of the LIS possible from the current
 * element(corresponding to curposcurpos) onwards(including the current
 * element). Inside each function call, we consider two cases:
 * 
 * The current element is larger than the previous element included in the LIS.
 * In this case, we can include the current element in the LIS. Thus, we find
 * out the length of the LIS obtained by including it. Further, we also find out
 * the length of LIS possible by not including the current element in the LIS.
 * The value returned by the current function call is, thus, the maximum out of
 * the two lengths.
 * 
 * The current element is smaller than the previous element included in the LIS.
 * In this case, we can't include the current element in the LIS. Thus, we find
 * out only the length of the LIS possible by not including the current element
 * in the LIS, which is returned by the current function call.
 *
 *
 * In Above algo,we keep processing sub-array many times .This repetition can be
 * avoided by memoizing the array in DP array.Let DP be array storing the length
 * of LIS.At each step,we keep incrementing the counter in dp array.
 * Now iterate over the dp array to find the maximum value.This maximum value is 
 * length of Longest Increasing Subsequence.We can merge this step while computing
 * the LIS to above reprocessing of DP Array
 * 
 * 
 */

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		int size = nums.length;
		if (size == 0)
			return 0;
		int dp[] = new int[size];

		Arrays.fill(dp, 1);
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		int maxIndex = 0;
		for (int i = 0; i < size; i++) {
			if (dp[i] > dp[maxIndex]) {
				maxIndex = i;
			}
		}
		return dp[maxIndex];
	}

	public static void main(String args[]) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

		System.out.print(lis.lengthOfLIS(nums));

	}
}
