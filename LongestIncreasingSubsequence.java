import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISSequence(nums);
    }
    // TC: O(N log N) where N is length of nums
    // SC: O(N) where N is length of nums
    private int lengthOfLISSequence(int[] nums) {
        int n = nums.length;
        int[] sequence = new int[n];
        sequence[0] = nums[0];
        int sequenceIndex = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sequence[sequenceIndex - 1]) {
                sequence[sequenceIndex] = nums[i];
                sequenceIndex++;
            } else {
                int indexToReplace = findIndexToReplace(sequence, 0, sequenceIndex - 1, nums[i]);
                sequence[indexToReplace] = nums[i];
            }
            res = Math.max(res, sequenceIndex);
        }
        return res;
    }
    private int findIndexToReplace(int[] sequence, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sequence[mid] == target) {
                return mid;
            } else if (sequence[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    // TC: O(N * N) where N is length of nums
    // SC: O(N) where N is length of nums
    private int lengthOfLISDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
