// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We sort the envelopes by width in ascending order and by height in descending order for envelopes with the same width.
// Then we find the length of the longest increasing subsequence of heights using binary search.
// We use binary search to find the index of the element in the array which is greater than or equal to the current element.
// If it is greater than the last element in the array, we add it to the end of the array.
// Otherwise, we replace the element at that index with the current element.    
// The length of the array at the end will be the length of the longest increasing subsequence.

import java.util.*;

class Solution {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;

        int[] arr = new int[n];
        arr[0] = envelopes[0][1];

        int len = 1;

        for (int i = 1; i < n; i++) {

            if (envelopes[i][1] > arr[len - 1]) {

                arr[len] = envelopes[i][1];
                len++;

            } else {

                int index = binarySearch(arr, 0, len - 1, envelopes[i][1]);
                arr[index] = envelopes[i][1];
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}