class Solution {
    public int maxEnvelopes(int[][] envelopes) {
     
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if(arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1] ;
            }
            return arr1[0] - arr2[0];
        });
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        
        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<i;j++) {
                if(envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
         int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}