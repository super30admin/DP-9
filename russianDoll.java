// Time Complexity : O(NLogN) (for arrays.sort) + O(N^2) (for LIS part)= O(N^2)
// Space Complexity : O(N) for DP array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//The idea is same as LIS. ONly thing is we need to sort the array (in ascending order) according to dimension 0. If dimension 0 is same, then sort according to dimension 1 (ascending order).
//Sorting is needed because the envelopes are dependent on sizes.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes == null || envelopes.length == 0) return 0;
        
        Comparator<int[]> customComparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else{
                    return a[0] - b[0];
                }
            }
        }; 
        
        Arrays.sort(envelopes, customComparator);
      
        
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        
        int maxLength = 1;
        
        for(int i=1; i<dp.length;i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && dp[i]<= dp[j]){
                    dp[i] = 1 + dp[j];
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}
