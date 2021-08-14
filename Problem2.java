
// time - O(n^2)
// space - O(n)


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null) return 0;
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]); //sort according to the width of the envelopes
        int [] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max = 1;

        for(int i = 1; i < envelopes.length; i++) {
            for(int j = 0; j < i; j++){
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) { //check the height & width of the envelopes
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}