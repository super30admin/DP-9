// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)-> {//sorting envelops on their height
            return a[0]-b[0];
        });
        
        int dp[]= new int[envelopes.length];
        Arrays.fill(dp,1);
        int maxcount=1;
         for(int i=1;i<envelopes.length;i++){
            for(int j=0;j<i;j++){ //storing the number of envelopes which can be russian dolled to it's left.
                if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]>envelopes[j][0] ){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxcount=Math.max(maxcount, dp[i]);
        }

        return maxcount;
        
    }
}