class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b) -> a[1] - b[1]);
        int [] dp = new int [envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        
        for(int i = 1; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                // check if next element is greater and check whether the elements are equal
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
