import java.util.Arrays;

public class LongestSubsequence {
    // DP is not an optimal solution. The alternative method will be optimized one.
    // TC : O(n^2)
    // SC : O(n)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i=1; i < n;i++) {
            for(int j=0; j < i;j ++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // Optimized approach
    // TC : O(n * log n)
    // SC : O(n)
    public int lengthOfLIS2(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for(int i=1; i < n; i++) {
            if(nums[i] > dp[len-1]){
                dp[len] = nums[i];
                len++;
            }else {
                int searchIndex = binarySearch(dp, 0, len - 1, nums[i]);
                dp[searchIndex] = nums[i];
            }
        }

        return len;
    }

    private int binarySearch(int[] dp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(dp[mid] == target){
                return mid;
            }else if(target < dp[mid]) {
                high = mid - 1;
            }else
                low = mid + 1;
        }

        return low;
    }
}
