/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n^2)
* 
* Space Complexity: O(n)
* 
*/

import java.util.Arrays;

public class LISTabulation {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int index = 0; index < n; index++) {
            for (int prevIndex = index - 2; prevIndex >= -1; prevIndex--) {
                if (nums[index] > nums[prevIndex + 1]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prevIndex + 1]);
                }
            }

        }

        int maxLength = 1;

        for (int element : dp) {
            maxLength = Math.max(element, maxLength);
        }

        return maxLength;
    }
}