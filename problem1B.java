class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        
        for(int i = 1; i < n; i++){
            if(nums[i] > dp[len - 1]){
                dp[len] = nums[i];
                len++;
            }
            else{
                int idx = binarySearch(dp, 0, len - 1, nums[i]);
                dp[idx] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] dp, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(dp[mid] == target){
                return mid;
            }
            else if(target < dp[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

//time complexity O(n * log n) where n is length of given array
//space complexity O(n)