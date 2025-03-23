// Time Complexity :O(N^2) + nlogn
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    //TC: O(N^2)
   /* public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] == b[0]){
               return b[1] - a[1];// if width same, check height ans sort descending
            }else{
                return a[0] - b[0];// ascending arrangement 
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];

        int max = 1;
        Arrays.fill(dp, 1);

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1+ dp[j]);// Max between its onw old and 1 + dp[j]
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/

// Time Complexity :O(nlogn)
// Space Complexity : O(N)
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] == b[0]){
               return b[1] - a[1];// if width same, check height ans sort descending
            }else{
                return a[0] - b[0];// ascending arrangement 
            }
        });

        int n = envelopes.length;
        int[] result = new int[n];
        result[0] = envelopes[0][1];// fill first value with first height
        int len = 1;
        for(int i = 1; i < result.length; i++){
            if(envelopes[i][1] > result[len - 1]){// if new value is greater than prev value, then add new value it // MIS: wrote i instead of len 
                result[len] = envelopes[i][1];// MIS: wrote i instead of len
                len++;

            }else{ // search a number just greater than our number, and replace it. eg [3,4] and we got 2, replace it with 3
                int bsIndex = searchJustGreaterNo(result, 0, len - 1, envelopes[i][1]); // MIS: wrote i instead of len
                result[bsIndex] = envelopes[i][1];
            }
        }

        return len;
    }

    private int searchJustGreaterNo(int [] res, int low, int high, int target){

        while(low<= high){
            int mid = low + (high - low)/2;
            if(res[mid] == target){ // if our target is 4 and we found 4 in out res[] then return that
                return mid;
            }else if(res[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;

    }
}