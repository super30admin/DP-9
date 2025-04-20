import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * We generate a subsequence by putting the number where it should
 *  have been if it were an increasing subsequence using binary search
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> output = new ArrayList<>();
        output.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > output.get(output.size() - 1)) {
                output.add(num);
            } else {
                int index = binarySearch(output, num);
                output.set(index, num);
            }
        }

        return output.size();
    }

    private int binarySearch(List<Integer> output, int num) {
        int low = 0;
        int high = output.size();
        while (low < high) {
            int mid = low + (high - low)/2;
            if (output.get(mid) == num)
                return mid;
            
            if (output.get(mid) < num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        // Your code here
    }
}