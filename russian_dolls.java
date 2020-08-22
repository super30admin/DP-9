//TC: O(n^2)
//SC: O(n)
//Approach: First we sort the given array based on both width and height, and once that is done, everytime I encounter an increasing substring, I try to increment the present position in DP array by taking maximum of all the preceeding values

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length<=1) return envelopes.length;
        
        //Logic
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        int maxValue=0;
        for(int i=1;i<envelopes.length;i++){
            int maxSub = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
                    maxSub = Math.max(maxSub,dp[j]);
                }
            }
            if(maxSub != Integer.MIN_VALUE)
                dp[i]=dp[i]+maxSub;
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }
}
