// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Did not run 1 test case
// Any problem you faced while coding this : No

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
        if(a[0] == b[0]){
            return a[1] - b[1]; 
        }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int result[] = new int[n];
        result[0] = envelopes[0][1];
        int len =1;

        for(int i = 1; i<n; i++){
            if(envelopes[i][1] > result[len-1]){
                result[len] = envelopes[i][1];
                len++;
            }
            else{
                int index = bSearch(result, 0, len-1, envelopes[i][1]);
                result[index] = envelopes[i][1];
            }
        }
        return len;
    }

    private int bSearch(int []nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}
