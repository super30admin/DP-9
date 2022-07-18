// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
