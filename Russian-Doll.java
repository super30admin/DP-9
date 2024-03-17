/*Time Complexity: O(N log N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Binary Search

Prob: 354. Russian Doll Envelopes
*/

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> { 
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int len = 1;
        int [] temp = new int[n];
        temp[0] =  envelopes[0][1];
        for(int i = 1; i < n; i++){
            if(temp[len-1] < envelopes[i][1]){
                temp[len] =  envelopes[i][1];
                len++;
            }
            else{
                int idx = Arrays.binarySearch(temp, 0, len, envelopes[i][1]);
                if(idx < 0){
                    idx = -idx-1;
                }
                temp[idx] = envelopes[i][1];
            }
        }
        return len;
    }
}