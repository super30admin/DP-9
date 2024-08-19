/*
    LC - 354. Russian Doll Envelopes
    TC - O(n logn) for sorting + n * (logn for bsearch) ~ 2 n logn ~ n logn
    SC - O(n)
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0]; // ascending order based on width
            }
            return b[1] - a[1]; // descending order based on height
        });
        int n = envelopes.length;
        int[] result = new int[n];
        result[0] = envelopes[0][1];
        int len = 1;
        for(int i=1; i<n; i++) {
            if(envelopes[i][1] > result[len - 1]) {
                result[len] = envelopes[i][1];
                len++;
            } else {
               int bsIndex = binarySearch(result, 0, len - 1, envelopes[i][1]);
               result[bsIndex] = envelopes[i][1]; 
            }
        }
        return len;
    }
    public int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}