// TC - O(n^2), SC - O(n)

// LC - 354

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
		// Initially we sort the array based on length
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
		// create a new dp array of size envelopes length
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
		// for every i, we check from 0 to i-1, if j's both length and width are greater than i's we add dp[i] + 1 
        for(int i=1; i<envelopes.length; i++){
            for(int j=0; j<i; j++){
                if((envelopes[i][0] > envelopes[j][0]) && (envelopes[i][1] > envelopes[j][1])){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }   
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}