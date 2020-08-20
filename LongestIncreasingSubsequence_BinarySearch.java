// Time Complexity : O(n log(n)) --> where n is the length of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (300): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int arr[] = new int[n]; // effective increasing subsequence array
        int len = 0;
        arr[len++] = nums[0];
       
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[len - 1]) {
                arr[len++] = nums[i];
            }
            else {
                // replace it with the right index
                // by ninary search the appropriate index in my arr
                int idx = binarySearch(arr, 0, len-1, nums[i]);
                arr[idx] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}