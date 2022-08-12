// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // This is Like Longest subsequence
        // First we should sort on height or width to fix one dimension
        Arrays.sort(envelopes, (a, b) -> {
            if(a[1] == b[1]) return b[0] - a[0]; // this is imp -> if height are equal then sort in decreasing order to prevent their width in same increasing sequence
            return a[1] - b[1];
        });

        // since height is fixed :: focus on width :: find the largest increasing subseq on width
        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int num = envelopes[i][0];

            if (num > arr[len - 1]) {
                arr[len] = num;
                len++;
            } else {
                // replace the num in arr using BS
                int bi = BinarySearch(arr, 0, len - 1, num);
                arr[bi] = num;
            }
        }
        return len;
    }

    private int BinarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low)/2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target ) high = mid - 1;

        }
        return low;
    }
}