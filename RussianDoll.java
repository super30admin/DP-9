//time o(n pow 2)
//o(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        int len = envelopes.length;
        int[] dp = new int[len];
        int max=1;
        Arrays.fill(dp, 1);
        
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            else {
                return a[0] - b[0];
            }
        });
        
        for(int i=1; i<len; i++) {
            for(int j=0; j<i; j++) {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}