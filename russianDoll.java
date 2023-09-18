// Time Complexity : O(nlog(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Sort the array based on the width of the doll. If two dolls have same width, sort the dolls based on heights in decreasing order. So that next doll is skipped.
 * Ussing LIS approach, find the length and return it.
 */


import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int len = 1;

        for(int i=1; i<n; i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }else {
                int idx = search(arr, 0, len-1, envelopes[i][1]);
                arr[idx] = envelopes[i][1];
            }
        }

        return len;
    }

    private int search(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }
}