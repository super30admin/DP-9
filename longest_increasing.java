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