// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach: Sorrted the array on one of the dimensions. Used a output array which has the previous information related to longest array.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (int[] a, int[] b) -> (a[0] - b[0]));
        int[] output = new int[envelopes.length];
        int max = 0;

        Arrays.fill(output, 1);

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    output[i] = Math.max(output[i], output[j] + 1);
                }
            }
            max = Math.max(max, output[i]);
        }

        return max;

    }
}