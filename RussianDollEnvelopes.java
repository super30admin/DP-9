package DynamicProgramming9;

import java.util.Arrays;

public class RussianDollEnvelopes {
    /* Created by palak on 8/12/2021 */

    /**
     * https://leetcode.com/problems/russian-doll-envelopes/

     Time Complexity: O(n log n)
     Space Complexity: O(n)
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null)   return 0;
        int max = 1;
        Arrays.sort(envelopes, (a, b) -> a[1] - b[1]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
