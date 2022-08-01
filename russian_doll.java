// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] greedy = new int[n];
        // sort according to width and if width is equal, sort in desc order according
        // to height
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        greedy[0] = envelopes[0][1];
        int len = 1;
        // for each element check
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > greedy[len - 1]) {// if current element is greater than last element in greedy array,
                // add
                // in greedy array
                greedy[len] = envelopes[i][1];
                len++;
            } else {
                // if not, find elemet just greater or equal to current element using binary
                // search and replace with
                // curr elements
                int idx = searchInd(greedy, envelopes[i][1], 0, len - 1);
                greedy[idx] = envelopes[i][1];
            }

        }
        return len;
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