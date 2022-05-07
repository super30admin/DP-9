// Time Complexity : O(n logn) n is the number of envelopes
// Space Complexity : O(n) for lis array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Sort the envelpes according to height
// Now use LIS with n logn complexity to find longest increasing subsequence for width
// For LIS check the LIS problem solution
// Finally return the LIS size as our answer
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                else{
                    return a[0] - b[0];
                }
            }
        });
        int[] secDimen = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++)
            secDimen[i] = envelopes[i][1];
        return sizeLIS(secDimen);
    }
    public int sizeLIS(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num: nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0){
                i = -(i+1);
            }
            dp[i] = num;
            if(i == len){
                len++;
            }
        }
        return len;
    }
}