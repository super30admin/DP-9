
/**
 * Sort envelopes by width ascending and height descending, then apply LIS on heights.
 * This reduces the 2D nesting problem into a 1D longest increasing subsequence problem.
 * Time Complexity: O(n log n), Space Complexity: O(n)
 */

import java.util.*;

public class RussianDoll {

    public int maxEnvelopes(int[][] envelopes) {

        // Step 1: Sort by width ASC, and if equal width then height DESC
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // Step 2: LIS on heights
        int[] lis = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int h = env[1];

            int idx = Arrays.binarySearch(lis, 0, len, h);
            if (idx < 0) idx = -(idx + 1);

            lis[idx] = h;
            if (idx == len) len++;
        }

        return len;
    }
}