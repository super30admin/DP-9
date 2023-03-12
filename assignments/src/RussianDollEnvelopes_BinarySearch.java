// Approach: 1. Sort according to widths, if widths same, reverse sort those by heights.
// 2. Substitution of heights less than ones already present in effective increasing subsequence in arr[].
// 3. Binary search used as the algo. to substitute at the correct places.
// Note: Not possible to give the exact envelopes as the subsequence would just be an effective one, not the actual one.
// Time: O(nlogn)
// Space: O(n)

import java.util.Arrays;

class RussianDollEnvelopes_BinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return (b[1] - a[1]);
            }
            return a[0] - b[0];
        });
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int arrSize = 1;

        for (int i = 1; i<n; i++) {
            if (envelopes[i][1] > arr[arrSize - 1]) {
                arr[arrSize] = envelopes[i][1];
                arrSize++;
            } else {
                int bsIdx = binarySearch(arr, 0, arrSize-1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }
        return arrSize;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}