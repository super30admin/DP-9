// TC - O(n^2), SC - O(n)

// LC - 300

class Solution {
    public int lengthOfLIS(int[] nums) {
		// Sanity check
        if(nums == null || nums.length == 0){
            return 0;
        }
        // Initialize a new dp array of size nums.length
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
		// for every i, we check if nums[i] > nums[j] from 0 to i-1, if yes, we add 1 + dp[j] or dp[i], else max of dp[i] or 1
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }else{
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         if(nums == null || nums.length == 0){
//             return 0;
//         }
        
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         int max = 1;
//         for(int i=1; i<nums.length; i++){
//             for(int j=0; j<i; j++){
//                 if(nums[i] > nums[j]){
//                     dp[i] = Math.max(dp[i], 1+dp[j]);
//                 }
//             }
//             max = Math.max(max, dp[i]);
//         }
//         return max;
//     }
// }