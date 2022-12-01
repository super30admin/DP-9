// Time Complexity: O(NlogN)
// Space Complexity: O(N)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums ==null || nums.length == 0) return 0;

        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];
        int len = 1;

        for (int i=1; i < n; i++) {
            if (nums[i] > result[len - 1]) {
                result[len] = nums[i];
                len++;
            } else {
                int idx = binarySearch(result, nums[i], 0, len-1);
                result[idx] = nums[i];
            }
        }

        return len;
    }

    private int binarySearch(int[] result, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (result[mid] == target) {
                return mid;
            } else if (target < result[mid]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}