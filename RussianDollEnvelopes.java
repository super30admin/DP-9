// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int le = 1;

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > arr[le - 1]) {
                arr[le] = envelopes[i][1];
                le++;
            } else {
                int bsIdx = binarySearch(arr, 0, le - 1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }

        return le;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}