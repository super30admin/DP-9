// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RussianDollEnvelopes {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            if(n == 0 || envelopes == null)
                return 0;

        /*Similar to increasing sub sequence problem
        sort the matrix based on width - if heights are same
        sort the descending of heights
        then use effective increasing subsequence arr method */

            int[] arr = new int[n];
            int len = 1;

            Arrays.sort(envelopes, (a, b) -> {
                if(a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            });

            arr[0] = envelopes[0][1];
            for(int i = 0; i < n; i++){
                if(envelopes[i][1] > arr[len-1]){
                    arr[len] = envelopes[i][1];
                    len++;
                }
                else{
                    int bsIdx = binarySearch(arr, 0, len-1, envelopes[i][1]);
                    arr[bsIdx] = envelopes[i][1];
                }
            }
            return len;
        }

        private int binarySearch(int[] arr, int l, int h, int target){
            while(l <= h){
                int mid = l + (h - l) / 2;
                if(arr[mid] == target){
                    return mid;
                }
                else if(arr[mid] > target){
                    h = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
