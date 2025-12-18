import java.util.Arrays;

/*
Solution to LeetCode 354 - Russian Doll Envelopes
Approach:
- Sort the envelopes by width ascending. When widths are equal, sort by height descending.
  This ensures envelopes with the same width are not placed together in an increasing height sequence.
- Extract the heights and compute the Longest Increasing Subsequence (LIS) of heights using
  the patience-sorting (tails) method with binary search.
- The LIS length on heights after the sort equals the maximum number of envelopes that can be nested.

Time Complexity: O(n log n) due to sort O(n log n) and LIS with binary search O(n log n)
Space Complexity: O(n) for auxiliary arrays
LeetCode: https://leetcode.com/problems/russian-doll-envelopes/
*/
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) ->
        {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] array = new int[n];
        array[0] = envelopes[0][1];
        int le = 1;

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > array[le - 1]) {
                array[le] = envelopes[i][1];
                le++;
            } else {
                int bsIndex = findBsIndex(array, envelopes[i][1], 0, le - 1);
                array[bsIndex] = envelopes[i][1];
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.deepToString(envelopes));
        return le;
    }

    private int findBsIndex(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(
                new int[][]{{46, 89},
                        {50, 53},
                        {52, 68},
                        {72, 45},
                        {77, 81}}));
    }
}
