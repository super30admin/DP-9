// In this problem, sorting the array first with ascending order of widths and if the width is same then desc order of the heights.
// Then this problem becomes the LIS problem. So finding the length of LIS after sorting, that length gives us the ans.
// Time Complexity : O(n^2)
// Space Complexity : O(n) dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Russian doll - LIS with dp array - Time limit exceeded
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Base case
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // Sort
        Arrays.sort(envelopes, (a, b) -> {
            // If width same then sort by desc order of heights
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            // Else ascending order of widths
            return a[0] - b[0];
        });
        int n = envelopes.length;
        // Keep a max for storing max of all dp array elements
        int max = 1;
        // Declare dp array
        int[] dp = new int[n];
        // Fill it with 1
        Arrays.fill(dp, 1);
        // Loop from 1 to n
        for (int i = 1; i < n; i++) {
            // Inner will run from 0 to i
            for (int j = 0; j < i; j++) {
                // Check if both the width and height is greater at i than j
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    // Than at dp[i] store the max
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            // Update max
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// This is second approach of LIS. Here we take an array and keep on adding
// heights to the array if they are greater than the height present at the last
// position in the result array. If smaller than doing a binary search to find
// the value that is just greater than this height and then replacing it in the
// result array. Atlast the length of this result array is our answer.
// Russian doll - LIS with binary search - optimized

// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Base case
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // Sort same way
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        // Result array
        int[] result = new int[n];
        // Add the first height to it
        result[0] = envelopes[0][1];
        // Take length as 1
        int len = 1;
        // Loop from 1 to n
        for (int i = 1; i < n; i++) {
            // Check if the current height is greater, add it in the array
            if (envelopes[i][1] > result[len - 1]) {
                result[len] = envelopes[i][1];
                len++;
            } else {
                // Else search the index of the height in array, which has value just greater
                // than our current height
                int BsIndex = binarySearch(result, 0, len - 1, envelopes[i][1]);
                // Replace at that place
                result[BsIndex] = envelopes[i][1];
            }
        }
        return len;
    }

    // Binary search method
    private int binarySearch(int[] nums, int low, int high, int target) {
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