// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //o(n^2)time and o(n)space

        int n = envelopes.length;
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0] ){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;

    }

    class Solution {
        //o(nogn)time and o(n)space
        public int lengthOfLIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int[]arr = new int[n];
            arr[0] = nums[0];
            int len = 1;
            for(int i = 1; i < n; i++){
                if(nums[i] > arr[len-1]){
                    arr[len] = nums[i];
                    len++;
                } else {
                    int idx = bs(arr, nums[i],  0, len-1);
                    if(idx != -1){
                        arr[idx] = nums[i];
                    }
                }
            }
            return len;
        }
        private int bs(int[]arr, int target, int low, int high){
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(arr[mid] == target){
                    return mid;
                } else if(arr[mid] > target){
                    high = mid -1;
                } else{
                    low = mid +1;
                }
            }
            return low;
        }
    }
}