import java.util.Arrays;

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * First sort and then perform longest Increasing subsequence
 */

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] result = new int[n];                
        result[0] = envelopes[0][1];
        int len = 1; 
        for(int i = 1; i < n; i++) {
            if(envelopes[i][1] > result[len - 1]) {
                result[len] = envelopes[i][1];
                len++;
            }
            else {
                int bsIndex = binarySearch(result, 0, len - 1, envelopes[i][1]);
                result[bsIndex] = envelopes[i][1];                
            }
        }
        return len;
    }
    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2; //prevent integer overflow
            if(nums[mid] == target) {
                return mid;
            }
            else if(target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1; 
            }
        }
        return low;
    }

    public static void main(String[] args) {
        // Your code here
    }
}