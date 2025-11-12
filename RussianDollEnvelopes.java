/*
* Approach1: Tabulation similar to LIS on either width or height
    - Idea is to sort either one of the dimensions, lets say height
        - but when we have two same heights then we want to sort the width by decreasing order so that we always get a strictly increasing subsequence
        - Once the sorting is done, we can do LIS tabulation on the unsorted dimension
    - TC: O(n^2) -> nested iteration to fill dp array
    - SC: O(n) -> dp array
    - The above approach gives TLE

* Approach2: Binary search to find LIS on 2nd dimension like how we did on LIS
TC: O(nlogn) -> binary search + iterating over the envelopes width
SC: O(n) -> effective increasing subsequence array

 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1]; 
            return a[0] - b[0];
        });

        int[] arr = new int[envelopes.length];
        int le = 1;
        arr[0] = envelopes[0][1];

        for(int i = 1; i < envelopes.length; i++){
            if(envelopes[i][1] > arr[le - 1]){
                arr[le] = envelopes[i][1];
                le++;
            }
            else{
                int idx = binarySearch(arr, 0, le - 1, envelopes[i][1]);
                arr[idx] = envelopes[i][1];
            }
        }
        return le;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return low;
    }
}