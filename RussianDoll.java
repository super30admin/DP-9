//TC:O(NLogN)
//SC : O(N)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;

        Arrays.sort(envelopes,(a,b) ->{
            if(a[0] == b[0])
                return b[1] - a[1];

            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;

        for(int i=1;i<n;i++)
        {
            if(dp[len-1] < envelopes[i][1])
            {
                dp[len] = envelopes[i][1];
                len++;
            }
            else
            {
                int bIndex = binarySearch(dp,0,len-1,envelopes[i][1]);
                dp[bIndex] = envelopes[i][1];
            }
        }
        return len;
    }

    private int binarySearch(int[] dp, int low, int high, int target){
        while(high>=low){
            int mid = low+(high-low)/2;
            if(target == dp[mid]) return mid;

            if(dp[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}