// Time Complexity : O(n) + O(logn) - to search a position to insert elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


import java.util.Arrays;

public class RussianDolls {

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int n = envelopes.length;
        //sorting based on widths
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });


        int []arr = new int[n];
        int len = 0;

        for(int i = 0; i < n;i++){
            if(i == 0 ||
                    (envelopes[i][1] > arr[len-1])){
                arr[len++] = envelopes[i][1];
            }else{
                int insertPos = binarySearch(arr, 0, len-1, envelopes[i][1]);
                arr[insertPos] = envelopes[i][1];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
