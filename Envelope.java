import java.util.Arrays;
//Time Complexity : O(NLogN)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply sorting to sort them in ascending order and descending order on height.
 * Then find the index to be placed for each height in the dp array. after
 * placing all the indices, find the count of dp array and return the count.
 *
 */
class Solution {
	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		int n = envelopes.length;
		int[] dp = new int[n];
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			int index = binarySearch(dp, 0, maxLen, envelopes[i][1]);
			dp[index] = envelopes[i][1];
			if (index == maxLen)
				maxLen++;
		}
		return maxLen;
	}

	public int binarySearch(int[] arr, int i, int j, int target) {
		while (i < j) {
			int mid = i + (j - i) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				j = mid;
			else
				i = mid + 1;
		}
		return i;
	}
}
