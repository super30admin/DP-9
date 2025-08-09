// Time Complexity : O(n log(n))
// Space Complexity : O(n)
import java.util.*;
public class RussianDollEnvelope {
    static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] arr = new int[n];
        Arrays.sort(envelopes, (a,b)->{
            if(a[1] == b[1]) return  b[0] - a[0];
            return a[1] - b[1];
        });
        arr[0] = envelopes[0][0];
        int len = 1;
        for(int i=1; i<n; i++){
            if(envelopes[i][0] > arr[len-1]) {
                arr[len] = envelopes[i][0];
                len++;
            } else {
                arr[binarySearch(arr, 0, len-1, envelopes[i][0])] = envelopes[i][0];
            }
        }
        return len;
    }

    static int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("Maximum Envelops:" + maxEnvelopes(envelopes));
    }
}
