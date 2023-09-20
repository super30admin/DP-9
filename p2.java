// Time Complexity : O(nlog(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int[] res = new int[envelopes.length];
        int len = 1;
        res[0] = envelopes[0][1];
//Go through all the elements
        for(int i=1; i<envelopes.length; i++){
            //If it's in increasing order, add the element to result array
            if(envelopes[i][1] > res[len-1]){
                res[len] = envelopes[i][1];
                len++;
            } else{
                //If it's not in increasing order, find the index which needs to be replaced
                int ind = search(res, 0 , len-1, envelopes[i][1]);
                res[ind] = envelopes[i][1];
            }
        }

        return len;
    }

    //Function for binary search
    private int search(int[] res, int l, int r, int target){
        

        while(l <= r){
            int mid = l + (r-l)/2;
            if(res[mid] == target){
                return mid;
            }
            else if(res[mid] > target){
                r= mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return l;
    }

}