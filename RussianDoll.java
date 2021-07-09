/*
Desc : here we sort the envelopes according to their widths and perform longest increasing subsequence on it
according to its hieght, the maximum of these sizes of sub sequences would be the result
Time Complexity : O(n^2)
Space Complexity : O(nn)
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length==0) return 0;
        Arrays.sort(envelopes,(a,b) -> a[0] - b[0]);//sorting with respect to the width.
        int dp[] = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i < envelopes.length; i++){
            for(int j = 0; j< i; j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){//second condition is checked to avoid any occurance where the widths are repeated or where two widths are equal
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max,dp[i]);
            }
            
        }
        return max;
    }
}
