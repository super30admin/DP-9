//Time Complexity - O(nlog(n))
//Space Complexity - O(n)
class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;

        int[] result = new int[n];
        result[0] = envelopes[0][1];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if(envelopes[i][1] > result[len-1]) {
                result[len] = envelopes[i][1];
                len++;
            } else {
                int bsIndex = binarySearch(result, 0, len - 1, envelopes[i][1]);
                result[bsIndex] = envelopes[i][1];
            }
        }
        return len;
    }

    private int binarySearch(int[] result, int l, int r, int target){
        while(l<=r){
            int mid = r + (l-r)/2;
            if(result[mid] == target){
                return mid;
            } else if (result[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
