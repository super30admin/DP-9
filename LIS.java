// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    
    private int BS(int[] dp,int low, int high,int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(dp[mid] == target) return mid;
            else if(dp[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > dp[len-1]) dp[len++] = nums[i];
            else{
                int index = BS(dp,0,len-1,nums[i]);
                dp[index] = nums[i];
            }
        }
        
        return len;
        
        
//         int n = nums.length;
//         int[] dp = new int[n];
//         int max = 1;
//         Arrays.fill(dp,1);
//         for(int i = 1; i < n ; i++){
//             for(int j = 0 ; j < i ; j++){
//                 if(nums[i] > nums[j]){
//                     dp[i] = Math.max(dp[i],dp[j]+1);
//                     max = Math.max(dp[i],max);
//                 }
//             }
//         }
        
//         return max;
    }
}
