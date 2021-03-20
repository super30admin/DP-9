// Time Complexity : The time complexity is O(n2) where n is the length of array
// Space Complexity : The space complexity is O(n) where n is the length of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        int max = 0;
        int[] dp = new int[n];

        //sort the array
        Arrays.sort(envelopes,(int[] a,int[] b) -> a[0] - b[0]);

        for(int i=0;i<n;i++){
            dp[i] = 1;
            //check for russian doll condition
            for(int j=0;j<i;j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}