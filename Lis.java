// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int le = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > arr[le - 1]) {
                arr[le] = nums[i];
                le++;
            } else {
                int bsIdx = binarySrch(arr, 0, le - 1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }

    private int binarySrch(int[] arr, int i, int j, int el) {
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] == el) {
                return m;
            } else if (arr[m] > el) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}