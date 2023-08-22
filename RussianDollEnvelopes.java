import java.util.Arrays;

public class RussianDollEnvelopes {

    //Time Complexity: O(NlogN)
    //Space Complexity: O(N)
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) ->{
            if(a[0] == b[0]) return (b[1] - a[1]);
            return (a[0] - b[0]);
        });

        int[] arr = new int[envelopes.length];
        arr[0] = envelopes[0][1];

        int idx = 1;
        for(int i = 1; i < envelopes.length; i++){
            if(arr[idx-1] < envelopes[i][1]){
                arr[idx] = envelopes[i][1];
                idx++;
            }
            else{
                int index = searchBinary(arr, 0, idx-1, envelopes[i][1]);
                arr[index] = envelopes[i][1];
            }
        }

        return idx;
    }

    private int searchBinary(int[] arr, int begin, int end, int target){

        while(begin <= end){
            int mid = (begin+ end)/2;
            if(arr[mid] == target) return mid;
            if(target > arr[mid]) begin = mid +1;
            else end = mid - 1;
        }

        return begin;
    }
}
