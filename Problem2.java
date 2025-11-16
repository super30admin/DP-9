// Time Complexity : O(n log n) where n is the number of envelopes
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Sort the envelopes array in ascending order of height. If the heights are same, then sort them in descending order of width which will give us pure increasing subsequence array of width.
 *
 * Use binary search to calculate the longest increasing subsequence which will be the total number of stacked dolls in the response.
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // sort in ascending order of height and descending order of width
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] arr = new int[envelopes.length];
        arr[0] = envelopes[0][1];
        int idx = 1;
        for (int i = 0; i < envelopes.length; i++) {
            if (envelopes[i][1] > arr[idx - 1]) {
                arr[idx] = envelopes[i][1];
                idx++;
            } else {
                int swapIdx = binarySearch(arr, 0, idx - 1, envelopes[i][1]);
                arr[swapIdx] = envelopes[i][1];
            }
        }

        return idx;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}