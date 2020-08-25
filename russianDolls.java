//time complexity O(n^2)
//space complexity O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int max = 1;
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
