//TC: O(n^2)
//SC: O(n)
//running on leetcode: yes
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;
        int n= envelopes.length;
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int[] dp=new int[n];
        int max=1;
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++){
            for (int j=0; j<i; j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i]=Math.max(dp[i],1 + dp[j]);
                    max=Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
