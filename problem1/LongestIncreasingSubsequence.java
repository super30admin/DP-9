// Time Complexity : O(nlog n), n -> size of array 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	/********************* DP *********************/
	// Time Complexity : O(n^2), n -> size of array
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int lengthOfLISDP(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] dp = new int[n];

		Arrays.fill(dp, 1);

		int ans = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ans = Math.max(ans, dp[i]);
				}
			}
		}
		return ans;
	}

	/********************* Binary Search *********************/
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		List<Integer> arr = new ArrayList<>();
		arr.add(nums[0]);

		for (int i = 1; i < n; i++) {
			if (nums[i] > arr.get(arr.size() - 1)) {
				arr.add(nums[i]);
			} else {
				arr.set(binarySearch(arr, nums[i]), nums[i]);
			}
		}

		return arr.size();
	}

	private int binarySearch(List<Integer> arr, int num) {
		int low = 0;
		int high = arr.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) == num) {
				return mid;
			} else if (arr.get(mid) > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

		System.out.println("Length of longest increasing subsequence: " + obj.lengthOfLIS(nums));
	}

}
