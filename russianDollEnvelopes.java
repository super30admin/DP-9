// Problem2: Russian Doll Envelopes (https://leetcode.com/problems/russian-doll-envelopes/)

// Time Complexity : O(nlogn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, sort the envelopes such that 0th indices are in increasing order and when there is same 0th index sort 1st index in decreasing order.
 * Take an array of size n and take arr[0] = envelopes[0][1] and le = 1 its the effective idx. While traversing along the envelopes ifarr[le-1] < envelopes[i][1]
 * then take arr[le] = envelopes[i][1] else replace the number just greater than nums[i]. Finally return le.
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0]-b[0];
        });
        int []arr = new int[envelopes.length];
        arr[0] = envelopes[0][1];
        int le = 1;
        for(int i = 1; i < envelopes.length; i++){
            if(arr[le-1] < envelopes[i][1]){
                arr[le] = envelopes[i][1];
                le++;
            }
            else{
                int idx = binarySearch(arr, 0, le-1, envelopes[i][1]);
                arr[idx] = envelopes[i][1];
            }
        }
        return le;
    }
    private int binarySearch(int []arr, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}