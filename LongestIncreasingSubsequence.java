// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        arr[0] = nums[0];
        int le = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[le - 1]) {
                arr[le] = nums[i];
                le++;
            } else {
                int bsIdx = binarySearch(arr, 0, le - 1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }

        return le;

    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}