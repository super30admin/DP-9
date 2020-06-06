//Time Complexity: O(n^2)
//Space Complexity: O(n)

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int size = nums.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        for(int i = 0; i < size; i++){
            for(int j = 0; j <= i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < size; i++){
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
