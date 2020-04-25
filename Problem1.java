// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach: Used a output array which has the previous information related to longest array.

class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] output = new int[nums.length];
        int max = 0;

        Arrays.fill(output, 1);

        for (int j = 0; j < nums.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (nums[j] > nums[i]) {
                    output[j] = Math.max(output[j], 1 + output[i]);
                }
            }
            max = Math.max(max, output[j]);
        }

        return max;

    }
}