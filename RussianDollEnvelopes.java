//TC : O(n*logn)-- Sorting pairs in log(n) time .
//SC : O(n) // using 1D array


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0]; // If heights are same, sort widths in reverse(decreseing)
            }
            return a[1] - b[1]; /// SORTING Pairs bases on heights
        });
        
        int[] result = new int[envelopes.length];
        int c = 1;
        result[0] = envelopes[0][0];
        
        for(int i = 1; i< envelopes.length; i++){
            if(envelopes[i][0] > result[c-1]){ // If incoming element is larger than most recently added element in Sequence
                result[c] = envelopes[i][0];
                c++;
            }else{
                int index = effectiveBinarySearch(result, 0, c-1,envelopes[i][0] );
                result[index] = envelopes[i][0];
                
            }
            
        }
        return c;
    }
    public int effectiveBinarySearch(int[] array, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(array[mid] == target)    return mid;
            else if(array[mid] <= target)   l = mid + 1;
            else h = mid - 1;
        }
        
        return l; // index where target should be stored
    }
}


/*
//Time limit exceeded
//TC : O(n*logn)-- Sorting pairs in log(n) time .
//SC : O(n) // using 1D array
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0]; // If heights are same, sort widths in reverse(decreseing)
            }
            return a[1] - b[1]; /// SORTING Pairs bases on heights
        });
        int max = 1;
        int l = 1;
        int[] result = new int[envelopes.length];
        
        Arrays.fill(result, 1);
        for(int i = 1; i< envelopes.length; i++){
            for(int j = 0; j< i; j++){
                if(envelopes[i][1] > envelopes[j][1] ){
                    result[i] = Math.max(result[i], result[j] + 1);
                    max = Math.max(result[i], max);
                }
            }
        }
        
        return max;
    } 
}
*/

/*


/*
//Time limit exceeded
//TC : O(n*logn)-- Sorting pairs in log(n) time .
//SC : O(n) // using 1D array

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0]; /// SORTING Pairs bases on Widths
        });
        int max = 1;
        int l = 1;
        int[] result = new int[envelopes.length];
        
        Arrays.fill(result, 1);
        for(int i = 1; i< envelopes.length; i++){
            for(int j = 0; j< i; j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]){
                    result[i] = Math.max(result[i], result[j] + 1);
                    max = Math.max(result[i], max);
                }
            }
        }
        
        return max;
    }
}

*/


    
   