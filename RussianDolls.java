// Time: O(NLogN) | Space: O(N)


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // sorting the envelopes first upon width, then if widths are equal, decreasing order of height
        // so that we don't encourter issue, when we go through them
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0] == b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int[] effectiveArr = new int[envelopes.length];
        effectiveArr[0] = envelopes[0][1];
        int len = 1;
        for(int i=1;i<envelopes.length;i++) {
            if(effectiveArr[len-1] < envelopes[i][1]) {
                effectiveArr[len] = envelopes[i][1];
                len++;
            } else {
                int bsIndex = binarySearch(effectiveArr, envelopes[i][1], 0, len-1);
                effectiveArr[bsIndex] =envelopes[i][1];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int target, int low, int high) {
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) low = mid+1;
            else high = mid -1;
        }
        return low;
    }
}