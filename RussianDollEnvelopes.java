// Time Complexity ; O(n log n) binary search traversal on n elements
// Space complexity: O(n) extra space for storing result list
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes){
        // Sort the envelopes
        Arrays.sort(envelopes,(a, b) -> { // a is width, b is height
            if(a[0] == b[0]){
                return b[1] - a[1];  // sort heights in descending order
            }
            return a[0]-b[0]; // sort width in ascending order
        });

        // Extract the heights

        int[] heights = new int[envelopes.length]; // create a 1D array heights with same size as number of envelopes
        for( int i =0; i < envelopes.length; i++){ // envelopes.length is number of rows in 2D array
            heights[i] = envelopes[i][1]; 
        }
        // apply LIS on heights
        return  lengthOfLIS(heights);
    }
    private int lengthOfLIS( int [] nums){
        List<Integer> result = new ArrayList<>();
        for( int num : nums){
            int pos = binarySearch( result, num);
            if(pos < result.size()){
                result.set(pos, num);
            } else{
                result.add(num);
            }
        }
        return result.size();
    }

    private int binarySearch(List<Integer> result, int target){
        int left = 0;
        int right = result.size()-1;
        while( left <= right){
            int mid = left + (right - left)/2;
            if(result.get(mid) > target){
                right = mid - 1;
            } else{
                left = mid+ 1;
            }
        }
        return left;
    }

    public static void main ( String []args){
        RussianDollEnvelopes solution = new RussianDollEnvelopes();
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        System.out.println("Maximum number of envelopes: " + solution.maxEnvelopes(envelopes));
    }
}

