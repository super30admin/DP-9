// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes == null || envelopes.length == 0)  return 0;
        
        //sort the array based on the width
        Arrays.sort(envelopes,(a,b) -> (a[0] - b[0]));
        
        //to store the number of envelopes in the dp array
        int dp[] = new int[envelopes.length + 1];
        
        //initialize all the elements in the dp array with 1
        Arrays.fill(dp,1);
        
        //minimum number of envelopes we can have is 1 i.e. if we have only one element in the array, then maximum envelopes we can Russian Doll is one.
        int maxEnvelopes = 1;
        //[2,3],[5,4],[6,4],[6,7]
        
        for(int i = 0; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
            
                //if the width and height of the next envelope is greater than the width and height of the previous envelope
                if(envelopes[i][0] > envelopes[j][0] &&
                    envelopes[i][1] > envelopes[j][1]){
                    
                    //update the dp array to choose the maximum number of envelopes
                    dp[i] = Math.max(dp[i], dp[j] + 1); //choose and don't choose so we choose whichever is the maximum
                    
                    //global maximum to find the maximum number of envelopes we can Russian Doll.
                    maxEnvelopes = Math.max(maxEnvelopes, dp[i]);
                }
            }
        }
        return maxEnvelopes;
    }
}
