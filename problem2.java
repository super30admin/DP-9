    /**
    Time Complexity : O(N log N)
    Explanation:
    1) Sorting envelopes by width takes O(N log N)
    2) Longest Increasing Subsequence (LIS) on heights using binary search takes O(N log N)

    Space Complexity : O(N)
    Explanation:
    An auxiliary array is used to maintain LIS tails.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially sorting envelopes only by width caused incorrect nesting
    when widths were equal. Fixed it by sorting:
        - width in ascending order
        - height in descending order when widths are equal
    This prevents envelopes with the same width from being included
    in the LIS calculation.
    */

class Solution {



    public int maxEnvelopes(int[][] envelopes) {

        // Sort by width ascending, height descending
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int result = binarySearchSol(envelopes);
        return result;
    }

    private int binarySearchSol(int[][] envelopes) {

        int n = envelopes.length;
        int[] arr = new int[n];

        arr[0] = envelopes[0][1];
        int l = 1;

        for (int i = 1; i < n; i++) {

            if (envelopes[i][1] > arr[l - 1]) {
                arr[l] = envelopes[i][1];
                l++;
            }
            else {
                int bidx = binarySearch(arr, 0, l - 1, envelopes[i][1]);
                arr[bidx] = envelopes[i][1];
            }
        }

        return l;
    }

    // Binary search to find correct replacement index
    private int binarySearch(int[] arr, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}