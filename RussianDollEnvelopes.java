// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We sort the envelopes in the ascending order of width and if same width, descending order of lengths. Now, we
apply same logic of LongestIncreasingSubsequence where we take an array and feed the 1st envelope's height
and traverse through all the other envelopes and keep on appending if we find bigger heights, if not, do
a binary search and set the envelope height at the appropriate index. Lastly, return the length.
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int length = 1;

        for(int i = 1 ; i < n ; i++) {
            if(envelopes[i][1] > arr[length - 1]) {
                arr[length] = envelopes[i][1];
                length++;
            }
            else {
                int idx = binarySearch(arr, 0, length - 1, envelopes[i][1]);
                arr[idx] = envelopes[i][1];
            }
        }
        return length;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}