/*
 * Time complexity : O(n^2)
 * Space Complexity : O(n)
 */

import java.util.Arrays;

public class IncreasingSubsequence {

public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return 1;
        }
        
        int[] dp = new int[nums.length];
        int max = 1;
        
        Arrays.fill(dp, 1);
        
        for(int i = dp.length - 1; i >=0 ; i--){
            for(int j=dp.length - 1; j > i; j--){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}
