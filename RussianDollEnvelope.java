package com.example.problems;

import java.util.Arrays;
import java.util.Comparator;

//Time Complexity : O(N Log N) for Sorting + DP
//Space Complexity : O(N^2) for DP
//Did this code successfully run on Leetcode : yES
//Any problem you faced while coding this :nO

/* This problem asks us to find Longest Increasing SubSequence in 2-D Matrix( Place envelopes in envelopes).
 * To solve this problem,we need to sort the envelopes by width.If the width of envelopes match,then sort 
 * the envelopes by height.After sorting,store the height of all envelopes in array and problem reduces to 
 * finding Longest Increasing Subsequence in 1-D Array.
 * We can apply DP to solve LIS to find it
 * So Total Time Complexity is Log N for Sorting + N for DP =  O(N Log N) 
 * 
 * */
public class RussianDollEnvelope {
	public int LIS(int nums[]) {
		if (nums.length == 0) {
			return 0;
		}
		int size = nums.length;
		int dp[] = new int[size];
		Arrays.fill(dp, 1);
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int maxIndex = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > dp[maxIndex]) {
				maxIndex = i;
			}
		}
		return dp[maxIndex];
	}

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int a[], int b[]) {
				return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
			}
		});
		System.out.println(Arrays.deepToString(envelopes));

		int second[] = new int[envelopes.length];
		int size = envelopes.length;
		for (int i = 0; i < size; i++) {
			second[i] = envelopes[i][1];
		}
		return LIS(second);
	}

	public static void main(String args[]) {
		int envelopes[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		RussianDollEnvelope envelope = new RussianDollEnvelope();

		System.out.println(envelope.maxEnvelopes(envelopes));
	}
}
