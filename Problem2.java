// Time Complexity : O(nlogn) + O(n logn) ~ O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
First sort the array, based on increasing width, if width equal then sort by decreasing height
I created an effective arr to maintain the elements in increasing order.
If the curr element (i.e [i][1]) is greater than the last element of the effective arr, just add it to the end
Else use binary search to find where the element will fit into the effective arr.
Once I compute everything return the size of the effective array. It may not represent the exact subsequence but it can give the size
*/

import java.util.Arrays;

public class Problem2 {
    public int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int[] effArr = new int[envelopes.length];
        effArr[0] = envelopes[0][1];
        int effIdx = 1;
        for(int i = 1;i<envelopes.length;i++) {
            if(envelopes[i][1] > effArr[effIdx-1]) {
                effArr[effIdx] = envelopes[i][1];
                effIdx++;
            } else {
                int searchIdx = searchForPos(effArr, envelopes[i][1], 0, effIdx-1);
                effArr[searchIdx] = envelopes[i][1];
            }
        }

        return effIdx;
        
    }

    private int searchForPos(int[] effectiveArr, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(effectiveArr[mid] == target) {
                return mid;
            } else if(effectiveArr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
