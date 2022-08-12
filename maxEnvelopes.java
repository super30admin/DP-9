// approch 1 
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 using dp (TLE)
    public static int maxEnvelopes(int[][] envelopes) {
        // null case
        if (envelopes == null || envelopes.length == 0)
            return 0;
        // sort envelopes by it's width
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int n = envelopes.length;
        // dp array
        int[] dp = new int[n];
        // fill dp array with 1
        Arrays.fill(dp, 1);
        // atleast one envelopes is there
        // here I will check longest increasing subsequences of heights
        // by also checking if width is also greater
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // approch 2 using effective array
    public static int maxEnvelopes2(int[][] envelopes) {
        // null case
        if (envelopes == null || envelopes.length == 0)
            return 0;
        // sort envelopes by it's width
        Arrays.sort(envelopes, (a, b) -> {
            // if width is same sort in dec order of height
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            // return inc order of width
            return a[0] - b[0];
        });
        int n = envelopes.length;
        // effective array list
        List<Integer> list = new ArrayList<>();
        // add first enveleopes height in the list
        list.add(envelopes[0][1]);
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) < envelopes[i][1]) {
                list.add(envelopes[i][1]);
            } else {
                // get suitable index
                int bsIndex = binarySearch(list, envelopes[i][1]);
                list.set(bsIndex, envelopes[i][1]);
            }
        }
        return list.size();

    }

    // binary search for getting most suitable index for element
    private static int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // if target matches with mid index element
            if (target == list.get(mid))
                return mid;
            // else if in target is in first half
            else if (target < list.get(mid))
                r = mid - 1;
            else
                l = mid + 1;

        }
        return l;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        System.out.println(maxEnvelopes(envelopes));
        System.out.println(maxEnvelopes2(envelopes));
    }
}