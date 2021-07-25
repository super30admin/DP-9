package DP9;

import java.util.Arrays;

/*S30 FAANG Problem #154 {Hard} - https://www.youtube.com/watch?v=qAxa3f14SAE
    You have a List of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

    Find the maximum number of envelopes can you Russian doll given that rotation is not allowed.

    Example:

    Input: [[5,4],[6,4],[6,7],[2,3]]
    Output: 3
    Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

    Source Link: https://leetcode.com/problems/russian-doll-envelopes/
        -------------------------------------------------------------------------------------------------------
        Time complexity : o(n * n) and O(nlogn) with binary search
        space complexity: o(n)
        Did this code run successfully in leetcode : yes
        problems faces : no*/
public class RussianDolEnvelopes {
    
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;

    }

}
