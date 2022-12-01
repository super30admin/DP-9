package DP-9;

public class problem2 {
    class Solution {
        //TC:- O(n logn)
        //SC:- O(n)
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes == null || envelopes.length == 0) return 0;
            
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
            
            for(int i = 1; i < n; i++){
                if(envelopes[i][1] > arr[len - 1]){
                    arr[len] = envelopes[i][1];
                    len++;
                }
                else {
                    int idx = binarySearch(arr, envelopes[i][1], 0, len - 1);
                    arr[idx] = envelopes[i][1];
                }
            }
            
            return len;
        }
        
        public int binarySearch(int[] arr, int target, int low, int high){
            
            while(low <= high) {
                int mid = low + (high - low) / 2;
                
                if(arr[mid] == target){
                    return mid;
                }
                else if(target < arr[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            
            return low;
        }
    }
}
