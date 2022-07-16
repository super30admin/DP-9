import java.util.Arrays;

//Time Complexity : O(N^2)
//Space Complexity : (N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums==null) return 1;
        int n = nums.length;
        int [] dp = new int[n];
        int max =1;
        Arrays.fill(dp,1);
        //go through the array and check if number at i position is greater than number at j position
        //if greater update dp[i] to max between itself or the number length of longest substring found at j +1
        //update max 
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
                
            }
            
        }
        return max;
    }
}