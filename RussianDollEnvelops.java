// Time Complexity : O(logn + nlogn) - worst case do binary search for each number
// Space Complexity : O(n) 

// Did this code successfully run on Leetcode : yes

// Approach: Constraint one degree of freedom(width) by sorting, and find longest subsequence based on heights

class Solution {
    public int maxEnvelopes(int[][] envelopes) { 
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){ //width are same - sort in decreasing order of height
                return b[1] - a[1];
            }

            return a[0] - b[0]; // increasing order of width
        });
        int n = envelopes.length;

        int[] arr = new int[n];  // heights
        
        arr[0] = envelopes[0][1];
        int le = 1;

        for(int i = 1; i < n ; i++){
            if(envelopes[i][1] > arr[le-1]){
                arr[le] = envelopes[i][1];
                le++;
            }
            else{
                int bsIdx = binarySearch(arr, 0 , le-1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }
        return le;
    }

    //get the next big element
    private int binarySearch(int[] arr , int lo , int hi , int target){

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if( arr[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return lo; // next big number
    }
}