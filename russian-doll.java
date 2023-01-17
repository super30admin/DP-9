
//tc is O(nlogn)
//sc is O(n)
import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0)
            return 0;

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // increasing order of height
            }

            else {
                return a[0] - b[0]; // increasing order of width
            }
        });

        dp[0] = envelopes[0][1];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[len - 1]) {
                dp[len] = envelopes[i][1];
                len++;
            } else {
                int index = binarySearch(dp, 0, len - 1, envelopes[i][1]);
                dp[index] = envelopes[i][1];
            }
        }

        return len;

    }

    private int binarySearch(int[] envelopes, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == envelopes[mid]) {
                return mid;
            }

            else if (envelopes[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}