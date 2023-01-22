public class RussianDoll {

// TC - O(nlogn) SC O(n)

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int n =envelopes.length;
        int[] dp = new int[n];
        Arrays.sort(envelopes,(a,b)->  {
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];
        });
        dp[0] = envelopes[0][1];
        int len = 1;

        for(int i =1;i<n;i++){
            if(envelopes[i][1]>dp[len-1]){
                dp[len] = envelopes[i][1];
                len++;
            }
            else{
                int index  = binarySearch(dp, 0, len-1, envelopes[i][1]);
                dp[index] = envelopes[i][1];
            }

        }
        return len;
    }
    private int binarySearch(int[] dp, int low, int high, int target){
        while(low<=high){
            int mid = low+ (high - low)/2;
            if(target == dp[mid]) return mid;
            else if (target> dp[mid]) low = mid+1;
            else high = mid-1;

        }
        return low;
    }



    //TC O(n^2) SC O(n)
    /* public int maxEnvelopes(int[][] envelopes) {
     if(envelopes == null || envelopes.length == 0) return 0;
     int n =envelopes.length;
     int[] dp = new int[n];
     Arrays.sort(envelopes,(a,b)->  a[0]-b[0]);
     Arrays.fill(dp,1);
     int max=1;
     for(int i =1;i<n;i++){
         for(int j=0;j<i;j++){
             if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                 dp[i] = Math.max(dp[i],1+dp[j]);
                 max = Math.max(max,dp[i]);
             }

         }
     }
     return max;
    }*/
}
