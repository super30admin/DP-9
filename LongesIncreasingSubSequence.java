// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: Two pointers and Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int[] arr = new int[n];
        int length = 1;
        arr[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[length - 1]) {
                arr[length++] = nums[i];
            } else {
                int low = 0;
                int high = length - 1;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (arr[mid] >= nums[i]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                arr[low] = nums[i];
            }
        }
        return length;
    }
}
