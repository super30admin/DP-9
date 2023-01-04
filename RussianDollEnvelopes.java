package s30.dp.dp9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//algo:  same as nlogn longest increasing subsequence soln;

//TC: O(nlogn)
//SC: O(n)
public class RussianDollEnvelopes {


    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (x, y) -> {
            if(x[0] == y[0]){
                return y[1]-x[1];
            }

            return x[0] - y[0];
        });


        List<Integer> seq = new ArrayList();

        for(int i=0; i < envelopes.length; i++){

            if(i == 0 || seq.get(seq.size()-1) < envelopes[i][1]){
                seq.add(envelopes[i][1]);
            }
            else{
                int index = binarySearch(seq, envelopes[i][1]);

                seq.set(index, envelopes[i][1] );
            }

        }


        return seq.size();

    }


    private int binarySearch(List<Integer> seq, int ele){
        int start =0, end =  seq.size() -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            int midEle = seq.get(mid);

            if(midEle == ele) return mid;
            else if( ele > midEle ){
                start = mid+1;
            }
            else {
                end = mid -1;
            }

        }

        return start;
    }
    public static void main(String[] args) {

    }
}
