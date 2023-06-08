//same like longest increasing subsequence
//TC: O(nlogn)
//SC: O(n)
/**
 * Apply sorting to sort them in ascending order and descending order on height.
 * Then find the index to be placed for each height in the dp array. after
 * placing all the indices, find the count of dp array and return the count.
 *
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
            if(a[1] == b[1]){ //sorting based on height
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        
        int len = 1;
        int n = envelopes.length;
        int [] arr = new int[n]; //effective array
        arr[0] = envelopes[0][0];
        for(int i=1;i<n;i++){
            if(envelopes[i][0] > arr[len-1]){
                arr[len] = envelopes[i][0];
                len++;
            }else{
                int bsIndex = binarySearch(arr, 0, len-1, envelopes[i][0]);
                arr[bsIndex] = envelopes[i][0];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
