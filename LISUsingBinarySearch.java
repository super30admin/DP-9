public class LISUsingBinarySearch {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		len++;
		for (int i = 1; i < nums.length; i++) {
			if (dp[len - 1] < nums[i]) {
				dp[len] = nums[i];
				len++;
			} else {
				int index = binarySearch(dp, 0, len - 1, nums[i]);
				dp[index] = nums[i];
			}

		}

		return len;

	}

	private int binarySearch(int[] nums, int low, int high, int target) {

		while (low <= high) {

			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {

				return mid;
			} else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;

		}

		return low;

	}
}
