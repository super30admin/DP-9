// Longest Increasing Subsequence
// Time Complexity : O(n^2) where n = length of array
// Space Complexity : O(n) extra space for dp array

// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        // base condition
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // initializing dp array
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // performing dp
        for (int i=0; i<nums.length; i++) {
            // loop from start to index i
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int output = 0;
        // max
        for (int n : dp) {
            output = Math.max(output, n);
        }
        
        return output;
    }
}

// Russian Doll Envelopes
// Time Complexity : O(nlogn + n^2) where n = length of array
// Space Complexity : O(n) extra space for dp array

// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // base condition
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // sorting array by width
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // initializing dp array
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        int max = 0;
        // performing dp
        for (int i=0; i<envelopes.length; i++) {
            for (int j=0; j<i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
