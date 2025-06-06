// Time Complexity : O(n log n)
// Space Complexity : O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{ 
            if(a[1] == b[1]){
                return b[0] - a[0]; // Descending width for same height
            }
            return a[1] - b[1];  // Ascending height
        });

        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][0];
        int len = 1;

        for(int i=1; i<n; i++){
            if(envelopes[i][0] > arr[len-1]){
                arr[len] = envelopes[i][0];
                len++;
            }else{
                int bsIdx = binarySearch(arr, 0, len-1, envelopes[i][0]);
                arr[bsIdx] = envelopes[i][0];
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}
