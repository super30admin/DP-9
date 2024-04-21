// TC=O(nlogn)
// SC = O(n)
class Solution {
    public int maxEnvelopes(int[][] e) {
        int n = e.length;
        int[] arr = new int[n];
        Arrays.sort(e, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        arr[0] = e[0][1];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (e[i][1] > arr[len - 1]) {
                arr[len++] = e[i][1];
            } else {
                int bs = Arrays.binarySearch(arr, 0, len, e[i][1]);
                if (bs < 0) {
                    bs = -(bs + 1);
                }
                arr[bs] = e[i][1];
            }
        }
        return len;
    }
}