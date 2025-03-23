// TC: O(n ^ 2) nested loop is used to traverse the input array. sorting an array takes n log n but the higher order has priority
// SC: O(n) as the dp array is used to store the longest subsequence

// Runs on leetcode but with TLE
// Working: The logic is correct which is same as for the longest increasing subsequence 
// but has the leetcode expects to run with low time complexity. Hence the binary seach comes in.

// Updated logic: 
// TC: O(n log n) which comprises both sorting an array and the binary search logic
// SC: O(n) as the result array is used to store the increasing subsequence

// Working: After sorting the input array based on width, 
// the longest increasing subsequence works on the height using Binary search

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        System.out.println(maxEnvelopesUsingNestedLoop(new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } })); // 3
        System.out.println(maxEnvelopesUsingNestedLoop(new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 } })); // 1

        System.out.println(maxEnvelopesUsingBinarySearch(new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } })); // 3
        System.out.println(maxEnvelopesUsingBinarySearch(new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 } })); // 1
    }

    public static int maxEnvelopesUsingNestedLoop(int[][] envelopes) {
        if (envelopes == null)
            return 0;
        int count = 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            count = Math.max(count, dp[i]);
        }
        return count;
    }

    public static int maxEnvelopesUsingBinarySearch(int[][] envelopes) {
        if (envelopes == null)
            return 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int len = 1;
        int[] result = new int[n];
        result[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > result[len - 1]) {
                result[len] = envelopes[i][1];
                len++;
            } else {
                int index = binarySearch(result, 0, len - 1, envelopes[i][1]);
                result[index] = envelopes[i][1];
            }
        }
        return len;
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
