
//Time:O(NLogN)
//Space: O(N)

//sort using the width and find longest increasing subsequence using heights
//width is anyways increasing so we just need to find all increasing heights

import java.util.Arrays;

class russian {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        int[] dp = new int[envelopes.length];
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                //Make sure both height and width are increasing in order to consider them as valid
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}