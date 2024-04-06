class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Tc: O(nlogn) Sc: O(n)
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int arr[] = new int[n];
        arr[0] = envelopes[0][0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (envelopes[i][0] > arr[len - 1]) {
                arr[len] = envelopes[i][0];
                len++;
            } else {
                int bsInd = binarySearch(arr, 0, len - 1, envelopes[i][0]);
                arr[bsInd] = envelopes[i][0];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Tc: O(n^2) Sc: O(n)
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[1] - b[1]);

        int dp[] = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] &&
                        envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}