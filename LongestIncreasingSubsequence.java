// Time Complexity O(n log n) because of binary search
// Space complexity - O(n) storage space for result list
import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    private int lengthofLIS(int [] nums){
        List<Integer> sub = new ArrayList<>(); // this list will represent smallest possible LIS
        for( int num: nums){
            int pos = binarySearch(sub, num); // determines the position where number can be inserted using binary seacrh
            if( pos < sub.size()){ // if position is within bounds
                sub.set(pos,num); // then replace the value at pos with the num
            } else{
                sub.add(num); // otherwise append the number at the end
            }
        }
        return sub.size();

    }
    private int binarySearch(List<Integer> sub, int target){
        int left =0, right = sub.size() -1;
        while( left<= right){
            int mid = left + ( right - left )/2;
            if(sub.get(mid) >= target){
                right = mid -1;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main (String[] args){
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,1,8};
        System.out.println("length of longest subsequence" + " " + solution.lengthofLIS(nums));

    }
}
