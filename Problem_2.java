// Time Complexity : O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// First sort the given array to the desired value. then apply the longest common subsequence on the all the value and return the len counter
// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int [] dp = new int [n];
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        Arrays.fill(dp, 1);
        int sum = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0] ){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    sum = Math.max(sum, dp[i]);
                }
            }
        }
        return sum;

    }
}