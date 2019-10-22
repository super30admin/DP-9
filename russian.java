class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(int[] a, int [] b)->{return a[0]-b[0];
    });  // Sort the array on the basis of the width of the envelopes.
        int max=0;
        
    int[]dp = new int [envelopes.length]; 
        Arrays.fill(dp,1); // Fill the dp array with 1s as the minimum envelope count will be 1 in any case.
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[i][0]>envelopes[j][0] &&envelopes[i][1]>envelopes[j][1] ) // Condition to check if both width and height is greater
                {
                    dp[i]=Math.max(dp[j]+1,dp[i]); //if condition true, update the dp array.
                }
            }
            max = Math.max(dp[i],max);// get the longest increasing subsequence count.
        }
        return max; // return the max no. of envelopes.
    }
}
