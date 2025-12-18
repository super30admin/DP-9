import java.util.Arrays;

/*
Solution to LeetCode 300 - Longest Increasing Subsequence (O(n log n) approach)
Approach:
- Use patience sorting / tails array: maintain an array `array` where array[i] is the smallest possible tail value of an increasing subsequence of length i+1.
- For each number, if it's larger than the current largest tail, append it; otherwise binary-search to replace the first tail >= num.
- The length of the filled portion (le) is the LIS length.

Time Complexity: O(n log n)
Space Complexity: O(n)
LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/
*/
public class LongestIncreasingSubsequence2 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] array = new int[n];
        array[0] = nums[0];
        int le = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > array[le - 1]) {
                array[le] = nums[i];
                le++;
            } else {
                int bsIndex = findBsIndex(array, nums[i], 0, le-1);
                array[bsIndex] = nums[i];
            }
            System.out.println(Arrays.toString(array)+ " " + le);
        }

        return le;
    }

    private int findBsIndex(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence2().lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
    }
}
