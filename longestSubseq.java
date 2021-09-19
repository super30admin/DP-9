
//Time: O(N*N)
//Space: O(N)

//basic brute force:
//start iterating and for each element do choose and not choose based on if it is increasing subsequence or not
//DP approach:
//Start with an array of all 1s because if all descreasing the answer is 1
//Take two pointers, compare i and j
//if increasing order found, arr[i] = arr[j] + 1;
//return the max in the entire array
import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int max = 1;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}