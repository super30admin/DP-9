// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Using Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {

        // This is Based on Binary Search :: Creating effective array which is monotonically increasing
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int j = 1;

        for (int i = 1; i < n; i++) {
            // compare value at i and j
            if (nums[i] > arr[j - 1]) {
                // just add in arr -> increasing sequence
                arr[j] = nums[i];
                j++;
            } else {
                // find the proper place to insert/replace the nums[i] in effective array using BS
                int bi = BinarySearch(arr, 0, j-1, nums[i]);
                arr[bi] = nums[i];
            }
        }
        // return length of effective array as ans;
        return j;
    }

    private int BinarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low)/2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target ) high = mid - 1;

        }
        return low;
    }
}

// Uisng DP
// tc :: O(N^2)
// SC :: O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {

        // we will start from the smallest part and build on that
        // Initialization
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // maintain two pointers i and j
        // j will be the slider to move from 0 to i - 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}