// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Time Complexity = O(n log n)
// Space Complexity = O(n)

// Dynamic programming
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int len=1;

        // i will start from 1 till the end
        for (int i=1; i<n; i++) {
            if (nums[i] > dp[len-1]) {
                dp[len] = nums[i];
                len++;
            }
            else {
                // binary search
                int idx = binarysearch(dp, nums[i], 0, len-1);
                dp[idx] = nums[i];
            }
        }

        return len;
    }

    private int binarysearch(int[] dp, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (dp[mid] == target) return mid;
            if (dp[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }
}

// ------------------------------------------------------------------------------------------------------------------

// Time Complexity = O(n^2)
// Space Complexity = O(n)

// Dynamic programming
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return 0;

        int[] dp = new int[n];
        int max=1;
        Arrays.fill(dp, 1);

        // i will start from 1 till the end
        for (int i=1; i<n; i++) {

            // traverse j from 0 to 1 less than i
            for (int j=0; j<i; j++) {

                // when you find a number at i greater than at j,
                // we add 1 to the value at dp[j] and update dp[i] if dp[i] is previously less
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}