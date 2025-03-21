// In this approach, using the dp array initially filled with 1 indicating that each element in itself is a LIS. We will run 2 loops,
// outer loop i will run from 1 to n and inner j from 0 to i. So check if the nums[i]>nums[j], than at that value store in dp
// array, max of current value and 1 + dp[j]. Keep a max variable that will have max of all the dp values.

// Time Complexity : O(n^2)
// Space Complexity : O(n) dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Using dp array
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Keep max = 1 because if only 1 element that 1 is the answer
        int max = 1;
        int n = nums.length;
        // Declare dp array of size n
        int[] dp = new int[n];
        // Fill the array will 1 initially
        Arrays.fill(dp, 1);
        // Loop from 1 to n
        for (int i = 1; i < n; i++) {
            // Inner loop from 0 to i
            for (int j = 0; j < i; j++) {
                // Check if nums[i]>nums[j]
                if (nums[i] > nums[j]) {
                    // Than in dp[i] store the max of current value and 1 + dp[j]
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            // Then update max if required
            max = Math.max(max, dp[i]);
        }
        // Return max
        return max;
    }
}

// In this approach, running only one loop from 1 to n. And keeping one result
// array in which adding the first element. Now iterating
// over nums from 1 to n and checking if the current element is greater than the
// last element in result array than appending the current
// element in result else doing a binary search on result for searching the
// element which is just greater than the current element
// and making a swap. At last the length of this result array will give us the
// length of LIS
// Time Complexity : O(nlogn) doing binary search n times in worst case
// Space Complexity : O(n) result array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Binary search solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // Result array
        int[] result = new int[n];
        // Keep this length variable for the length of the result array
        int len = 1;
        // And add the first element in the result array
        result[0] = nums[0];
        // Now loop from 1 to n on nums
        for (int i = 1; i < n; i++) {
            // Check if nums[i] > than last element in result array
            if (nums[i] > result[len - 1]) {
                // Then add the current element at the last position in the result array
                result[len] = nums[i];
                // And increase the length
                len++;
            } else {
                // If the current is not greater, do a binary search and find the element which
                // is just little greater than the current element
                int BsIndex = BinarySearch(result, 0, len - 1, nums[i]);
                // And replace it with our current element
                result[BsIndex] = nums[i];
            }
        }
        // Return the len of result array
        return len;
    }

    // Binary search method
    private int BinarySearch(int[] result, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (result[mid] == target) {
                return mid;
            } else if (target > result[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}