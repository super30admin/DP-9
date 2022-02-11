// Time Complexity = O(n^2)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// DP solution, where we maintain a len and add to the dp array only when we find an element that has a value greater than the last element in the dp array
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        if (envelopes == null || n == 0) return 0;

        // Sort in ascending order of first element and descending order of second element
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0]-b[0];
        });

        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int len=1;

        for (int i=1; i<n; i++) {
            if(envelopes[i][1] > dp[len-1]) {
                dp[len] = Math.max(dp[len], envelopes[i][1]);
                len++;
            }
            else {
                // binary search to find the element that is either equal or just greater than the current element, and update it
                int idx = binarysearch(dp, envelopes[i][1], 0, len-1);
                dp[idx] = envelopes[i][1];
            }
        }

        return len;
    }

    private int binarysearch(int[] dp, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (dp[mid] == target) return mid;
            if (dp[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }
}