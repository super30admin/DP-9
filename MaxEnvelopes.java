// Problem 354. Russian Doll Envelopes
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int l=1;
        for(int i=1; i<n; i++){
            if(envelopes[i][1] > arr[l-1]){
                arr[l] = envelopes[i][1];
                l++;
            }else{
                int bsIdx = binarySearch(arr, 0, l-1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }
        return l;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
