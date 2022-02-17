// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use dp to solve this
// we sort the given input
// We create 1d array
// We put loop through the array and if the envelopes[i][1] > dp [len -1] we add the
// element to the dp and increase the len
// else we find the element that is slightly greater than the element we have
// and we replace it

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 1;
        dp[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[len - 1]) {
                dp[len] = envelopes[i][1];
                len++;
            } else {
                int idx = binarySearch(dp, envelopes[i][1], 0, len - 1);
                dp[idx] = envelopes[i][1];
            }
        }
        return len;
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}