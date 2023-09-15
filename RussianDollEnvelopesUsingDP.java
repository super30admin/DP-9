import java.util.Arrays;

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// This will get time limit exceeded for larger input as input length can be 1 <= envelopes.length <= 10^5

public class RussianDollEnvelopesUsingDP {
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        // sorting based on width in acsending order
        Arrays.sort(envelopes, (a, b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];   // same width then sort based on height in descending order
            }
            return a[0] - b[0];
        });

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int result = dp[0];

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                int curr = envelopes[i][1];
                int prev = envelopes[j][1];
                if(curr > prev){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(result,dp[i]);
                }
            }
        }
        return result;
    }
}