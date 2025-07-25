// TC: O(n log n) sorting and binary search
// SC: O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] arr = new int[envelopes.length];
        int len = 1;
        arr[0] = envelopes[0][1];

        for (int i = 1; i < envelopes.length; i++) {

            if (arr[len - 1] < envelopes[i][1]) {
                arr[len] = envelopes[i][1];
                len++;
            } else {
                int idx = binarySearch(arr, envelopes[i][1], len);
                arr[idx] = envelopes[i][1];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int target, int len) {
        int low = 0;
        int high = len;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}