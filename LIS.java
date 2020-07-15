import java.util.*;

class LIS {

// Time Complexity : O(N^2) where N is length of nums
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        
        for(int i=1; i <dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

/**
 * 
 * // Time Complexity : O(N log N) where N is length of nums
   // Space Complexity : O(N)
 * 
 * public int lengthOfLIS(int[] nums) {
     
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int len = 0;
        dp[len++] = nums[0];
        
        for(int i=1; i<dp.length; i++){
            if(nums[i] > dp[len-1]){
                dp[len++] = nums[i];
            }
            else {
                int pos = binarySearch(dp, 0, len, nums[i]);
                dp[pos] = nums[i];
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


