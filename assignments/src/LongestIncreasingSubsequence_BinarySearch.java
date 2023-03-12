// Approach: Substitution of values in arr[] to get an effective increasing subsequence.
// Note: The subsequence may not be correct but the length will be.
// Binary search to replace the no.s less than the ones already present in the effective subsequence.
// Time: O(nlogn) better solution than DP: O(n^2)
// Space: O(n) can be made O(1) if i/p array itself is modified

class LongestIncreasingSubsequence_BinarySearch {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int arrSize = 1;

        for (int i = 1; i<n; i++) {
            if (nums[i] > arr[arrSize - 1]) {
                arr[arrSize] = nums[i];
                arrSize++;
            } else {
                int bsIdx = binarySearch(arr, 0, arrSize-1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return arrSize;
    }
    private int binarySearch(int[] arr, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}