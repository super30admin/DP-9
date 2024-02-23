// Time complexity:  O(nlogn)
// Space Complexity: O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if(a[1] == b[1]) return b[0]-a[0];                                                   // if index 1 is same, then reverse order of index 0
            return a[1]-b[1];                                                                    // ascending order of index 1
        });
        int[] arr = new int[n];                                                                  // we will go for longest increasing subsequence
        int len = 1;
        arr[0] = envelopes[0][0];
        for(int i=0; i<n; i++) {
            if(envelopes[i][0] > arr[len-1]) {
                arr[len] = envelopes[i][0];
                len++;
            }
            else {
                int binaryIndex = binarySearch(arr, 0, len, envelopes[i][0]);
                arr[binaryIndex] = envelopes[i][0];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {                         // binary search
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
