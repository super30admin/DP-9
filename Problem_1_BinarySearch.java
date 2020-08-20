// Time complexity - O(NlogN)
// Space complexity - O(N)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0; int n = nums.length;
        int [] dp = new int[n];
        dp[len++] = nums[0];
        for(int i = 1; i < n; i++){
            if(dp[len-1] < nums[i]){
                dp[len++] = nums[i];
            } else {
                int idx = binarySearch(dp, nums[i], 0, len - 1);
                dp[idx] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int [] dp, int target, int low, int high){
        while(low <= high){
        int mid = low + (high - low)/2;
        if(target == dp[mid]){
            return mid;
        } else if(dp[mid] > target){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        }
        return low;
    }
}
