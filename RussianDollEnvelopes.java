// LIS with Binary Search
// TC: O(n log n)
// SC: O(n)

// Similar approach to LIS but here we convert a 2D array to 1D array
// Sort the width [x][] in ascending order
// Sort the length [][y] in descending order if the widths of 2 elements are same
// In arr you are putting the 2nd dimension so envelopes[0][1] since dimension 1 is already sorted
// Now do LIS on the arr i.e. finding the subsequence and using binary search for replacing the next greater element in the arr
// compared to the ith element
// NOTE: here for length/height we do descending order so as to avoid conflict if the widths are same

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Arrays.sort(envelopes,(a,b) -> {
            
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
            
        });
        int[] arr=new int[n];
        arr[0]=envelopes[0][1];
        int le=1;
        
        for(int i=1;i<n;i++){
            if(envelopes[i][1] > arr[le-1]){
                arr[le]=envelopes[i][1];
                le++;
            } else {
                int target=envelopes[i][1];
                int bsIdx=binarySearch(arr,target,0,le-1);
                arr[bsIdx]=target;
            }
        }
        return le;
        
    }
    private int binarySearch(int[] arr,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<target){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return low;
    }
}