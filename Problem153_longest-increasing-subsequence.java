// Time Complexity: O(nlogn)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int arr[] = new int[n];
        int len = 1;
        arr[0] = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] > arr[len - 1]) {
                arr[len] = nums[i];
                len++;
            } else {
                int bsIndex = binarySearch(arr, nums[i], 0, len - 1);
                if(bsIndex != -1) {
                    arr[bsIndex] = nums[i]; 
                }
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}