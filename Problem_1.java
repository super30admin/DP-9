// 300. Longest Increasing Subsequence
// Time Complexity : O(n logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
// We can solve it using DP, but the time complexity is n^2. So will solve it using binarysearch.
// if the current number is grater than the existing seq, then increase the length and amend the same array.
// when the current number nums[i] is not grater than the existing seq, then replace the number with just grater than nums[i]. so will apply binarysearch to search index of that grater element

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // int []arr = new int[n];
        // arr[0] = nums[0];

        int le = 1;
        for(int i = 1; i < n; i++) {
            //when nums[i] is grater, increase the length
            if(nums[i] > nums[le - 1]) {
                nums[le] = nums[i];
                le++;
            }
            //when nums[i] is not grater then replace the number with just grater than nums[i]
            else {
                //bsIdx will give index of array just grater than nums[i]
                int bsIdx = binarySearch(nums, 0, le-1, nums[i]);
                nums[bsIdx] = nums[i];
            }
        }
        return le;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}