// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Same as Longest Increasing Subsequence but we sort the array with w ascending and h in decending
// this is beacause when there is a tie in w, we want to consider the envelope with best possible fit
// eg  ...[2,3] [3,4], [3,3] -> [3,4] can fit [2,3] but cannot fit [3,3]

class Solution {
    List<Integer> result;

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        result = new ArrayList();

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]);
            else
                return Integer.compare(a[0], b[0]);
        });

        result.add(envelopes[0][1]); // first h1

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > result.get(result.size() - 1))
                result.add(envelopes[i][1]);
            else
                bsReplace(envelopes[i][1]);
        }

        return result.size();
    }

    private void bsReplace(int target) {
        int l = 0;
        int r = result.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == result.get(mid)) {
                l = mid;
                break;
            } else if (target < result.get(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        result.set(l, target);
    }

}