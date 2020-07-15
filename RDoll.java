import java.util.*;

public class RDoll {

    // Time Complexity : O(N^2) where N is number of envelopes 
    // Space Complexity : O(N) N is number of envelopes
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        int[] dp = new int[envelopes.length];
        int max = 1;
        Arrays.fill(dp, 1);
        
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }


    /**
     * // Time Complexity : O(N log N) where N is number of envelopes
        // Space Complexity : O(N)
     * 
     * public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        dp[len++] = envelopes[0][1];
        
        for(int i=1; i<dp.length; i++) {
            if(dp[len-1] < envelopes[i][1]){
                dp[len++] = envelopes[i][1];
            }
            else {
                int pos = binarySearch(dp, 0, len, envelopes[i][1]);
                dp[pos] = envelopes[i][1];
            }
        }
        
        return len;
    }
    
    
    private int binarySearch(int[] dp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(dp[mid] == target) {
                return mid;
            }
            
            if(dp[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
     */
}