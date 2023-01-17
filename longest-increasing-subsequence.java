
//tc is O(nlogn)
//sc is O(n)
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                // we do binary search to find an index where the
                int index = binarySearch(dp, 0, len - 1, nums[i]);
                dp[index] = nums[i];

            }
        }

        return len;

    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow

            if (nums[mid] == target) {
                return mid;
            }

            else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return low;
    }
}