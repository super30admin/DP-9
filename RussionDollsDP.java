class Solution {
    //tc-o(n2)//sc-o(n)
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
        if(a[0] == b[0]){
            return a[1] - b[1];
        }
        return a[0]-b[0];//sorting based on width

        } );

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max =1;
        for(int i=1;i<envelopes.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0])//wrote this to consider same width
                //we can avoid this check by sorting in decending order of heights in comparator if a[0] == b[0] retrun b[1]-a[1]
                {
                   dp[i] = Math.max(dp[i],dp[j] +1);
                   max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}

-------

class Solution {
    //tc-o(n2)//sc-o(n)
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
        if(a[1] == b[1]){
            return b[0] - a[0];
        }
        return a[1]-b[1];

        } );

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max =1;
        for(int i=1;i<envelopes.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[i][0] > envelopes[j][0])
                {
                   dp[i] = Math.max(dp[i],dp[j] +1);
                   max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}