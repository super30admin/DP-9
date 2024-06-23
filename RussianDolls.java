// Time Complexity : O(N log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        int len=1;

        for(int i=1;i<n;i++){
            if(envelopes[i][1] > arr[len-1]) {
                arr[len] = envelopes[i][1];
                len++;
            }else{
                int bsIndex = binarySearch(arr, 0, len-1,envelopes[i][1]);
                arr[bsIndex]= envelopes[i][1];
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] >= target){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return low;
    }
}