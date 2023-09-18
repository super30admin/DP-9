// Time Complexity : O(nlog(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Create an effective LIS array, check if the incoming element is greater than the last element in the effective array.
 * If it is greater, then add it to effective array. If not, insert the element just greater than that element in the effetive array.
 * Finally, return the length of the effective array.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[len - 1] < nums[i]) {
                arr[len] = nums[i];
                len++;
            } else {
                int idx = search(arr, 0, len - 1, nums[i]);
                arr[idx] = nums[i];
            }
        }

        return len;
    }

    private int search(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}

/**
3,5,6,2,5,4,19,5,6,7,12

2,4,5,6,7,12
 */