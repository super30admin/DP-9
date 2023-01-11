// Time Complexity: O(N Log N)
// Space Complexity: O(N)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;

        int[] dp = new int[nums.length];
        int max = 0;

        for (int x : nums) {
            int i = 0, j = max;
            while (i != j) {
                int m = (i + j) / 2;
                if (dp[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            dp[i] = x;
            if (i == max) ++max;
        }
        return max;
    }
}