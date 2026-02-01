// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
First I created an effective arr to maintain the elements in increasing order.
If the curr element is greater than the last element of the effective arr, just add it to the end
Else use binary search to find where the element will fit into the effective arr.
Once I compute everything return the size of the effective array. It may not represent the exact subsequence but it can give the size
*/


public class Problem1 {
    public int lengthOfLIS(int[] nums) {
        int[] effectiveArr = new int[nums.length];

        effectiveArr[0] = nums[0];
        int effectiveIdx = 1;
        for(int i = 1;i<nums.length;i++) {
            if(nums[i] > effectiveArr[effectiveIdx-1]) {
                effectiveArr[effectiveIdx] = nums[i];
                effectiveIdx++;
            } else {
                int searchIdx = searchForPos(effectiveArr, nums[i], 0, effectiveIdx-1);
                effectiveArr[searchIdx] = nums[i];
            }
        }

        return effectiveIdx;
    }

    private int searchForPos(int[] effectiveArr, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(effectiveArr[mid] == target) {
                return mid;
            } else if(effectiveArr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}