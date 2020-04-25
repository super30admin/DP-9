// Time Complexity : O(nlogn + n^2) = O(n^2) as we check from each point backward looking for any lesser elements available.
// Space Complexity : O(n) as we store a DP array for increasing sequence so far.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
//  Our goal is to fit one envelop(which has lower dimension) into another with greater dimensions.
// Return the number of envelopes whchi can fit in each other.

// Appraoch
// Initially all the individual number is a sequence of 1 element.
// From each point trace back if the number behind is lesser. If so then include that in the increasing sequnec of current number
// if not trace back and check until reach 0th index
// Choose the maximum sequence of numbers can be extended at each point.
// Keep track of MAX_SEQ for each index and return the maximum value
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length ==0)
            return 0;
        
        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[0] - a[0];         // Oreder in Ascending order in terms of Width.
            }
        };
        
        Arrays.sort(envelopes, comp);
        int n = envelopes.length;
        int[] output_dp = new int[n];
        
        int maxNoOfEnvelop = 1;
        
        Arrays.fill(output_dp, 1); 
        for(int i=1; i<n;i++){
            for(int j=i; j>=0; j--){
                if(envelopes[i][0] < envelopes[j][0] &&        
                    envelopes[i][1] < envelopes[j][1]){    // Chek Hight and Width for each envelop prior to current envelop.
                    output_dp[i] = Math.max(output_dp[i], output_dp[j]+1);
                }
               maxNoOfEnvelop = Math.max(output_dp[i],maxNoOfEnvelop); 
            }
        }
        return maxNoOfEnvelop;
    }
}
