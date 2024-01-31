// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :-
import java.util.Arrays;

//Sort the arrays in increasing order of length, then the problem statement is reduced to finding the length of potential
//longest increasing subsequence
class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int arr[]= new int[n];
        //Sort envelopes in ascending order of length, if length is same, desc order of breadth
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        for(int[] i : envelopes){
            System.out.println(i[0]+","+i[1]);
        }

        //Find the potential longest increasing subsequence O(n log n)
        arr[0] = envelopes[0][1];
        int len = 1;
        for(int i=1;i<n;i++){
            int num = envelopes[i][1];
            if(num > arr[len - 1]){
                arr[len] = num;
                len++;
            }
            else{
                int bsIndex = binarySearch(arr, 0, len -1, num);
                arr[bsIndex] = num;
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int num){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == num)
                return mid;
            else if(arr[mid] > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}