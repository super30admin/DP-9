// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private int BS(int[] dp,int low, int high,int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(dp[mid] == target) return mid;
            else if(dp[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int len = 1;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        for(int i = 1; i < n; i++) {
            if(envelopes[i][1] > dp[len - 1]) {
                dp[len] = envelopes[i][1];
                len++;
            }
            else {
                int idx = BS(dp, 0, len - 1,envelopes[i][1]);
                dp[idx] = envelopes[i][1];
            }
        }
        return len;
    }
}
