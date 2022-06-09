// O(n^2) time complexity: nested for loop 
// O(n) space for dp array

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){ // compare with all elements before i 
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int longest = 0;
        for (int c : dp){
            longest = Math.max(longest, c);
        }
        return longest;
    }
}