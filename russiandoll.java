// Time Complexity: O(n log n) – sort envelopes (O(n log n)) and run LIS on heights with binary search (O(n log n)).
// Space Complexity: O(n) – auxiliary arr (tails) array up to size n.

// Sort by width asc and height desc (for equal widths) to prevent false nesting on ties.
// Run LIS on the sequence of heights: if h > last tail, append; else lower-bound binary search in arr and replace.
// The final length of arr is the maximum number of envelopes that can be nested.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{ 
            if(a[0] == b[0]){
                return b[1] - a[1]; // Descending height for same width
            }
            return a[0] - b[0]; // Ascending width
        });

        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int len = 1;

        for(int i=1; i<n; i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }else{
                int bsIdx = binarySearch(arr, 0, len-1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
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
