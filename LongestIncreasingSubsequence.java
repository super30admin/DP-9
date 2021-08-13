package DynamicProgramming9;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /* Created by palak on 8/12/2021 */

    /**
     Time Complexity: O(n ^ 2)
     Space Complexity: O(n)
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null)    return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1 ; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    /**
     * Using Binary Search:
         Time Complexity: O(n log n)
         Space Complexity: O(n)
     */
    public int lengthOfLISBS(int[] nums) {
        if(nums == null)    return 0;
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int len = 1;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > arr[len - 1]) {
                arr[len] = nums[i];
                len++;
            } else {
                int bIndex = binarySearch(arr, 0, len - 1, nums[i]);
                arr[bIndex] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)  return mid;
            else if(arr[mid] > target)  {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
