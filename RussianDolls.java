import java.util.Arrays;

public class RussianDolls {
     //o(nlogn) o(n)
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int arr[] = new int[n];
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        arr[0]= envelopes[0][1];
        int len = 1;
        for(int i = 1; i < n; i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }else{
                int bsIdx = binarySearch(arr, 0, len-1, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }
        return len;
    }

    public int binarySearch(int[] nums, int lo, int hi, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                return mid;
            } 
            if(nums[mid] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return lo; //for just greater element 
    }
}
