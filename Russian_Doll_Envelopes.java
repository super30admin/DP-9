import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //edge case
        if(envelopes == null || envelopes.length == 0)
            return 0;
        int maxEnvelopes = 1;
        Arrays.sort(envelopes, (a, b) -> a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i=1;i<envelopes.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    maxEnvelopes = Math.max(maxEnvelopes, dp[i]);
                }
            }
        }
        return maxEnvelopes;
    }
}

//time complexity - n ^ 2
//space complexity :  O(n) for the dp array