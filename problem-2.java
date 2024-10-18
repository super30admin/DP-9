// Time Complexity :O(n log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;  // Handle empty input case

        // Sort envelopes by width ascending, and height descending if widths are the same
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];  // Sort by height descending if widths are the same
            } else {
                return a[0] - b[0];  // Sort by width ascending
            }
        });

        // To find the maximum number of envelopes, apply LIS on the heights
        int[] dp = new int[n];
        int len = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int idx = binarySearch(dp, 0, len, height);
            dp[idx] = height;
            if (idx == len) len++;
        }

        return len;
    }

    // Binary search to find the index where the height should be inserted
    private int binarySearch(int[] dp, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}