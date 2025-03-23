import java.util.Arrays;

// TC: 0(n ^ 2) as all the integers are compared in the array
// SC: 0(n) dp array is used

// Runs successfully on leetcode
// Comparison of integers is done in increasing fashion with 2 loops.
// If increasing sequence is found then the its count is maintained in the dp array
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // 4
        System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 })); // 4
        System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 })); // 1
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}