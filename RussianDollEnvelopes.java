// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a, b) -> {
           
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            
            return a[0] - b[0];
        });
        
        int n = envelopes.length;
        
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        
        int length = 1;
        
        for(int i = 0; i < n; i++) {
            if(envelopes[i][1] > arr[length - 1]) {
                arr[length++] = envelopes[i][1];
            } else {
                int index = search(arr, 0, length - 1, envelopes[i][1]);
                arr[index] = envelopes[i][1];
            }
        }
        
        return length;
    }
    
    private int search(int[] arr, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}