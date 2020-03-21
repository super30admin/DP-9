//Time Complexity: O(n^2)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //base case
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2){
            return 0;
        }
        //size of the array
        int n = envelopes.length;
        //sort array using comparator to get min[] if either width is same
        Arrays.sort(envelopes, (int[] a, int[] b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];
        });
        //consider dp array
        int[] dp = new int[n];
        //fill the array with value 1
        //since initially longest subsequence is 1
        Arrays.fill(dp,1);
        int max=1;
        //for every i,j; dp[i] should be > dp[j]+1
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){ 
                //comparing the widths     
                if(envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        //return calculated max sequence formed
        return max;
    }
}