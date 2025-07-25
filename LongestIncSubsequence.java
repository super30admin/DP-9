// TC: O(n log n) binary search
// SC: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int len = 1;

        arr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (arr[len - 1] < nums[i]) {
                arr[len] = nums[i];
                len++;
            } else {
                // replace with just grater than nums[i]
                int idx = binarySearch(arr, nums[i], len);
                arr[idx] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int target, int len) {
        int low = 0;
        int high = len;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }
}