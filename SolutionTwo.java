// Time Complexity :O(n log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nopes

class SolutionTwo {
    public int maxEnvelopes(int[][] envelopes)
    {
        if(envelopes==null || envelopes.length==0)
            return 0;

        Arrays.sort(envelopes,(a,b)->a[0] - b[0]);

        int[] dp= new int[envelopes.length];

        Arrays.fill(dp,1);

        int max=1;

        for(int i=1;i<envelopes.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[j][1]<envelopes[i][1] && envelopes[j][0]!=envelopes[i][0])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);


                }
            }
        }


        return max;
    }
}