// Time Complexity : O(wlogw + h^2) where w is the width and h is the height
// Space Complexity : O(h) dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Sorting the other one keeping the first one intact
/* Your code here along with comments explaining your approach: Sort the envelopes in width or height as your choice. Then you get into a 
situation where you need the LCS of the other one. For finding, LCS, introduce a dp array and for each element, find the lcs from the start
and see if the max length lcs that needs to be kept. Return the length as the number of envelopes required.
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {    
     if(envelopes == null || envelopes.length == 0) return 0;
     int[] dp = new int[envelopes.length];                                                                      // LCS required
     Arrays.fill(dp,1);
     Arrays.sort(envelopes, (a,b)->a[0]-b[0]);                                                              // Sort it with width
    int max = 1;
    for(int i = 1; i < dp.length; i++){
        for(int j = 0; j < i; j++){                                                                             // Find LCS in height
            if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0] ){                        // If the ith height is greater and width is also greater, no equal values allowed
              dp[i] = Math.max(dp[i], dp[j] + 1);                                                       // update the max length
              max = Math.max(max, dp[i]);                                                                   
            }       
        }
    }
        return max;                                                                                         // Return the number envelopes required
    }
}