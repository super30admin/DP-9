import java.util.Arrays;

public class Problem1 {
    // DP solution
    // TC : O(n^2)
    // SC : O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // DP  with O(n) time complexity solution
    // TC : O(n^2)
    // SC : O(n)
    public int lengthOfLIS1(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];

        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[len - 1] < nums[i]) {
                dp[len] = nums[i];
                len++;
            } else {
                int index = binaryIdx(dp, nums[i], 0, len - 1);
                dp[index] = nums[i];
            }
        }
        return len;
    }

    private int binaryIdx(int[] dp, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
