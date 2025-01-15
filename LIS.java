// Approach : DP
// Time : O(n^2)
// Space : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // individual number in itself is a increasing number.
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // it means i is forming an increasing subsequene with j
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

// Approach : Using the idea of effective array and performing the Binary Search to find idx of the element just greater than current Height in that effective array
// Time : o(n) *O(logn) = O(nlogn)
// Space : O(n)
// Time : O(n^2)
// Space : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] arr = new int[n+1];
        arr[0] = nums[0];
        int len = 1; // pointer or effective array length
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[len - 1]) {
                arr[len] = nums[i];
                len++;
            } else {
                int bsIndex = binarySearch(arr, 0, len - 1, nums[i]);
                arr[bsIndex] = nums[i];
            }
        }
        return len; // len of effective array
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }
}