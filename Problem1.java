//Time = O(n^2), length of input array
//Space = O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the length of the longest increasing subsequence ending at nums[i]
        Arrays.fill(dp, 1); // initialize dp[i] to 1 for all i
        int maxLen = 1; // initialize the maximum length to 1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // if nums[i] is greater than nums[j], we can extend the increasing subsequence
                    dp[i] = Math.max(dp[i], dp[j] + 1); // update dp[i] as dp[j] + 1 if dp[j] + 1 is greater than dp[i]
                }
            }
            maxLen = Math.max(maxLen, dp[i]); // update the maximum length if dp[i] is greater than maxLen
        }
        return maxLen;
    }
}
