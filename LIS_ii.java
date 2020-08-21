//TC - O(NlogN)
//SC - O(N)
class Solution2 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int n = nums.length;
		int arr[] = new int[n];
		int len = 0;
		arr[len++] = nums[0];
		for (int i = 1; i < n; i++) {
			if (nums[i] > arr[len - 1]) {
				arr[len++] = nums[i];
			} else {
				int index = binarySearch(arr, 0, len - 1, nums[i]);
				arr[index] = nums[i];
			}
		}
		return len;
	}

	private int binarySearch(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}
}