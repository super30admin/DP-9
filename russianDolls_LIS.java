// Time Complexity : O(N^2), because of LIS implementation
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class russianDolls_LIS {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] secondIdx = new int[envelopes.length];
        
        for(int i = 0; i < envelopes.length; i++) {
            secondIdx[i] = envelopes[i][1];
        }
        
        return lenOfIncSubsequence(secondIdx);
    }
    
    private int  lenOfIncSubsequence(int [] nums) {
        //if(nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int longest = 0;
        for (int num: dp) {
            longest = Math.max(longest, num);
        }
        
        return longest;
    }
}
