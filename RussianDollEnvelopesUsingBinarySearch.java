import java.util.Arrays;
// Time Complexity : O(n log n) + O(n log n) -> O(n log n)
// for sorting and binary search
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class RussianDollEnvelopesUsingBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        // sorting based on width in acsending order
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];   // same width then sort based on height in descending order
            }
            return a[0] - b[0];
        });

        int[] arr = new int[n];
        int len = 1;
        arr[0] = envelopes[0][1];

        for(int i=1; i<n; i++){
            int curr = envelopes[i][1];
            if(curr > arr[len-1])
            {
                arr[len] = curr;
                len++;
            }else{
                int bIdx = binarySearch(arr,0,len-1,curr);
                arr[bIdx] = curr;
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low+(high - low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}