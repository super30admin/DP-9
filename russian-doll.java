// TC: O(nlogn)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int binarySearch(int[] dp, int val) {
        int lo = 0, hi = dp.length - 1, res = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (dp[mid] < val) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res + 1;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width in ascending order.
        // If widths are equal, sort by height in descending order.
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        // Create an array to keep track of the longest increasing subsequence of heights.
        int[] LIS = new int[envelopes.length + 1];
        Arrays.fill(LIS, Integer.MAX_VALUE);
        // Use a dummy value at index 0 for easier comparisons.
        LIS[0] = Integer.MIN_VALUE;
        
        int ans = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int val = envelopes[i][1];
            int insertIndex = binarySearch(LIS, val);
            ans = Math.max(ans, insertIndex);
            if (LIS[insertIndex] >= val) {
                LIS[insertIndex] = val;
            }
        }
        return ans;
    }
}
