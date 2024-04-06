class Solution {
    public int lengthOfLIS(int[] nums) {
        // Tc: O(nlogn) Sc: O(n)
        int n = nums.length;
        int arr[] = new int[n];
        arr[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[len - 1]) {
                arr[len] = nums[i];
                len++;
            } else {
                int bsInd = binarySearch(arr, 0, len - 1, nums[i]);
                arr[bsInd] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Tc: O(n^2) Sc: O(n)
        int n = nums.length;
        int dp[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Tc: O(2^n) Sc: O(n)
        return findLIS(nums, Integer.MIN_VALUE, 0);
    }

    private static int findLIS(int[] nums, int prev, int curPos) {
        if (curPos == nums.length) {
            return 0;
        }

        int taken = 0;
        if (nums[curPos] > prev) {

            taken = 1 + findLIS(nums, nums[curPos], curPos + 1);
        }

        int notTaken = findLIS(nums, prev, curPos + 1);
        return Math.max(taken, notTaken);
    }

}
