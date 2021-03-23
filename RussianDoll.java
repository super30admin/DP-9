//Time Complexity: o(n^2 logn)
//Space Complexity: o(n)
//Expln: In order to find the russian doll first sort the array in terms of any one vertex either width or height.
// Then perform Longest Increasing sub sequence by traverlling through j to i upto the length of the whole input
// Such that by filling the dp array by 1 first then travese if the i > j in vertex 1 which is not sorted in initial sort.
// IF it is greater than increment the count by taking max bw i and j in dp array and store the max at the end return the max.
// Max at end gives the longest possible russian doll sequence which is possible in the given array.
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[]a, int[]b)
            {
                return a[0]-b[0];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        dp[0] = 1;
        int count = 1;
        for(int i = 1; i < envelopes.length; i++)
        {
            for(int j =0; j < i; j++)
            {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0])
                {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    count = Math.max(count, dp[i]);
                }
            }
        }
        return count;
    }
}