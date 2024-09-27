// Time Complexity :O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // if widths are same then put in decreasing order.
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[len - 1]) {
                dp[len] = envelopes[i][1];
                len++;
            } else {
                int bsIndex = bSearch(dp, 0, len - 1, envelopes[i][1]);
                dp[bsIndex] = envelopes[i][1];
            }
        }
        return len;
    }

    private int bSearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}