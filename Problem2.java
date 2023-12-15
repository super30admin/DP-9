// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        int[] arr = new int[m];
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int le = 1;
        arr[0] = envelopes[0][1];
        for(int i = 1; i < m; i++){
            if(envelopes[i][1] > arr[le - 1]){
                arr[le] = envelopes[i][1];
                le++;
            }else{
                int bidx = binarySearch(arr,0,le-1,envelopes[i][1]);
                arr[bidx] = envelopes[i][1];
            }
        }
        return le;
    }
    public int binarySearch(int[] arr,int lo, int hi , int target){
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                hi = mid - 1;
            else 
                lo = mid + 1;
        }
        return lo;
    }
}