/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(nlogn)
* 
* Space Complexity: O(n)
* 
*/

import java.util.ArrayList;
import java.util.List;

public class LISBinarySearch {
    private void replaceElementatLowerBound(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) == target) {
                return;
            } else if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        arr.set(low, target);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> longestSubsequence = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            int size = longestSubsequence.size();

            if (size == 0 || longestSubsequence.get(size - 1) < nums[index]) {
                longestSubsequence.add(nums[index]);
            } else {
                replaceElementatLowerBound(longestSubsequence, nums[index]);
            }
        }

        return longestSubsequence.size();
    }
}
