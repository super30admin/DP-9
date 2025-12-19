// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We can solve this problem by maintaining an effective longest increasing subsequence array where we only count the increasing
// subsequence elements. We start by sorting the array by increasing order of width, if width is equal sort by descending order of heights. Now we maintain an effective
// longest increasing subsequence array for the heights. If the incoming height value in greater than the one in arr[curr] we add to the
// array. Else, we replace it with the next greater value. The size of the arr gives the longest increasing subsequence that is the maximum
// envelopes that can fit in.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> { //sort the array by increasing order of width, if width is equal sort by descending order of heights
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] arr = new int[n];
        int curr = 0;
        arr[0] = envelopes[0][1];
        for(int i = 1; i < n;i++){
            if(envelopes[i][1] > arr[curr]){ //if incoming height value is greater
                arr[curr+1] = envelopes[i][1]; //add to arr
                curr++;
            } else{
                int pos = binarySearch(arr, 0, curr, envelopes[i][1]); //replace the next greater value in arr
                arr[pos] = envelopes[i][1];
            }
        }
        return curr+1;
    }
    private int binarySearch(int[] arr, int low, int high, int target){ //binary search
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target > arr[mid]){
                low = mid+1;
            }else{
                high =mid-1;
            }
        }
        return low;
    }
}