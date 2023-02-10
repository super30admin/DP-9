// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int le = 1;

        for(int i = 1; i < n; i++){
            if(envelopes[i][1] > dp[le - 1]){
                dp[le] = envelopes[i][1];
                le++;
            } else {
                int bsIndex = binarySearch(dp, 0, le, envelopes[i][1]);
                dp[bsIndex] = envelopes[i][1];
            }
        }
        return le;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}