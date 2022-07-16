// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        // for each element
        for (int i = 0; i < n; i++) {
            // check at each element prior to i if it is smaller, add 1 to it and take
            // maximum
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
            // keep track of maximum number
            max = Math.max(max, dp[i]);

        }
        return max;
    }
}

// ------------BETTER SOLUTION_______________________
// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] greedy = new int[n];
        int length = 1;
        greedy[0] = nums[0];
        // for each element
        for (int i = 1; i < n; i++) {
            if (nums[i] > greedy[length - 1]) {// if current element is greater than last element in greedy array, add
                                               // in greedy array
                greedy[length] = nums[i];
                length++;
            } else {
                // if not, find elemet just greater or equal to current element using binary
                // search and replace with
                // curr element
                int ind = searchInd(greedy, nums[i], 0, length - 1);
                greedy[ind] = nums[i];
            }

        }
        return length;
    }

    public int searchInd(int[] nums, int target, int start, int end) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = low + (end - high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
