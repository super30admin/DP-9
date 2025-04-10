/*
 * TC: O(n log n)
 * SC: O(n)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // sort in ascending order of widths
        // but descending order of heights
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        // Find the longest increasing subsequence of heights
        List<Integer> heights = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int j = findIndex(heights, envelope[1]);
            if (j >= heights.size()) heights.add(envelope[1]);
            else heights.set(j, envelope[1]);
        }
        // return length of LIS
        return heights.size();
    }
    int findIndex(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(target == list.get(m)) {
                return m;
            }
            if(target < list.get(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
