// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int count = 0;
        int[] dp = new int[A.length];
        
        for(int i = dp.length - 3; i >= 0; i--){
            if(A[i+1] - A[i] == A[i+2] - A[i+1]){
                dp[i] = 1 + dp[i+1];
                count += dp[i];
            }
        }
        
        return count;
    }
}