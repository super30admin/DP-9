import java.util.Arrays;

// Time Complexity : Add : O(N *log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        maxEnvelopes(envelopes);
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) // If width are equal, then sort height in descending manner due to algorithm workflow
                return b[1]-a[1];
            return a[0]-b[0];  // Sort based on width
        });

        int n = envelopes.length;
        int[] result = new int[n];
        int k = 0;

        for(int i=0; i<envelopes.length; i++){  // T.C - O(N *log N)  S.C - O(N)
            if(i == 0 || envelopes[i][1]>result[k-1]){ // if height of envelope is greater than last element of result, simply append
                result[k] = envelopes[i][1];
                k++; // increment the index
            }
            else{
                //do binary search and see where it is supposed to be
                int index = binarySearch(result, 0, k-1, envelopes[i][1]);
                result[index] = envelopes[i][1];
            }


        }

        return k;
    }


    public static int binarySearch(int[] result, int start, int end, int target){
        while(start<end){
            int mid = start + (end-start)/2;
            if(result[mid] == target)
                return mid;
            else if(result[mid]<target)
                start = start+1;
            else
                end = mid;

        }

        return end;
    }
}

