import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /**
     tc - o(n2)
     sc - o(n) - dp array
     Approach.
     create dp array of lenth nums.
     add 1 at each index. Because at any given index longest subsequence is the element itself
     take 2 variable i and jdk.accessibility/i=1 j=0
     if i>j check the max between current dp[i] and dp[j] +1 and fill. and i ++
     if i!>j, ( i ++ and j =0;) - will be taken care of by inner loop.
     this approach can also be used ot get all the sub sequences
     and if asked for longest,  can get the longest of all and can return.
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
