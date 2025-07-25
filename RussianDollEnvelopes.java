// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : sort envelopes based on width (ascending order - if width is same descending order of heights), thereby restricting it
/// Now find longest increasing subsequence of heights 

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{ 
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int arr[] = new int[envelopes.length];
        arr[0] = envelopes[0][1];
        int le = 1;
        for(int i=1;i<envelopes.length;i++){
            if(arr[le-1] < envelopes[i][1]){
                arr[le] = envelopes[i][1];
                le++;
            }
            else{
                int idx = binarySearch(arr, 0, le, envelopes[i][1]);
                arr[idx] = envelopes[i][1];
            }
        }
        return le;
    }
    private int binarySearch(int arr[], int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}