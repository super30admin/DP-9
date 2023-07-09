// tc : O(nlogn)
// sc : O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //base cases such as null i/p handled by constraints
        //sort on increasing width and decresing height in same width
        Arrays.sort(envelopes, (a,b) -> 
        {
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];
        }
        );

        //get it new array
        int[] dp = new int[envelopes.length];
        for(int i =0 ; i<envelopes.length ; i++) dp[i] = envelopes[i][1];
        //LIS
        int len =0 ;
        for(int num : dp){
            int ind = Arrays.binarySearch(dp, 0, len, num);
            if(ind<0) ind = -ind-1;
            if(len==ind) len++;
            dp[ind]=num;
        }   
        return len;
    }
}
