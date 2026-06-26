// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Brute force DP also worked but is O(N^2) and this is O(NlogN) using binary search.
// We use binary search to find the index of the element in the array which is greater than or equal to the current element.
//  If it is greater than the last element in the array, we add it to the end of the array.
//  Otherwise, we replace the element at that index with the current element.
//  The length of the array at the end will be the length of the longest increasing subsequence.

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n];
        arr[0] = nums[0];

        int len = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] > arr[len - 1]) {

                arr[len] = nums[i];
                len++;

            } else {

                int index = binarySearch(arr, 0, len - 1, nums[i]);
                arr[index] = nums[i];
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}