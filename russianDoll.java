// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
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
                int bsIdx = binarySrch(arr, 0, le - 1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }
        return le;
    }

    private int binarySrch(int[] arr, int i, int j, int el) {
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] == el) {
                return m;
            } else if (arr[m] > el) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

}