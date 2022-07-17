package com.interview.s30.dp;

import java.util.Arrays;

/**
 * Leetcode 300: https://leetcode.com/problems/longest-increasing-subsequence/
 * Time Complexity : O(NlogN)
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums) {
        int index = 0;
        int length = nums.length;
        int result[] = new int[length];
        result[index] = nums[0];

        for (int i = 1; i < length; i++) {
            if (result[index] >= nums[i]) {

                int low = 0;
                int high = index - 1;
                int mid = 0;
                int target = nums[i];

                while (low <= high) {
                    mid = low + (high - low) / 2;
                    int midVal = result[mid];
                    if (target == midVal) {
                        low = mid;
                        break;
                    } else if (target > midVal) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                result[low] = nums[i];

            } else {
                result[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public int lengthOfLISLinearSearch(int[] nums) {
        int index = 0;
        int length = nums.length;
        int result[] = new int[length];
        result[index] = nums[0];

        for (int i = 1; i < length; i++) {
            if (result[index] >= nums[i]) {
                int j = 0;
                for (j = 0; j < index; j++) {
                    if (result[j] >= nums[i]) {
                        break;
                    }
                }

                result[j] = nums[i];
            } else {
                result[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public int lengthOfLISDPSolution(int[] nums) {
        int result = 1;
        int length = nums.length;
        int dp[] = new int[length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
}
