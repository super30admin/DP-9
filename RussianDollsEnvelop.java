/*
 The time complexity is O(N^2) and the space complexity is O(N) where N is number of envelopes

 Here, to avoid computing the sub problems again we use an array of length N called dp.

 Yes,  the solution passed all the test cases.
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        int len = envelopes.length;
        if(len==0){return 0;}

        //Since we can pick envelop from any index, the indexing can be changed. So sort the array with respect to width. Now we can
        //simply calculate the longest subsequence wrt to height. Here we handled the edge case of having equal width by placing the envelope
        // with more height before the envelope with less height.
        Arrays.sort(envelopes,(int[] a,int[] b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));

        int[] dp = new int[len];
        Arrays.fill(dp,1);

        int max = 1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){


                //If ith height is greater than the jth height than we can include j envelope into i.
                if(envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);

                    if(dp[i]>max){
                        max = dp[i];
                    }
                }
            }
        }

        return max;
    }
}