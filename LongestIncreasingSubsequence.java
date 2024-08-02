class Solution {
    // Time Complexity :O(n * log(n)) - to search throgh the effective array
    // Space Complexity :O(n) for the effective array we build
    // Did this code successfully run on Leetcode :yes
    // Any problem you faced while coding this :no

    public int lengthOfLIS(int[] nums) {
        if(nums == null){
            return 0;
        }
        int numberOfElements = nums.length;
        int[] subArray = new int[numberOfElements];
        subArray[0] = nums[0];
        int maxSubSequenceSize = 1;
        int subArrayLength = 1;

        for(int i = 1; i < numberOfElements; i++){
            if(nums[i] > subArray[subArrayLength - 1]){
                subArray[subArrayLength] = nums[i];
                subArrayLength++;
            }else{
                int replaceIdx = findTheClosestLargerNumber(subArray, 0, subArrayLength - 1, nums[i]);
                subArray[replaceIdx] = nums[i];
            }
        }
        return subArrayLength;
    }

    private int findTheClosestLargerNumber(int[] subArray, int low, int high, int target){
        while(low < high){
            int mid = low + (high - low)/2;
            if(subArray[mid] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }


    //O(n * n) DP using tabulation solution
    // Time Complexity :O(n * n) -
    // Space Complexity :O(n) for the dp array
    // Did this code successfully run on Leetcode :yes
    // Any problem you faced while coding this :no
     public int lengthOfLISDP(int[] nums) {
         if(nums == null){
             return 0;
         }

         int[] dp = new int[nums.length];
         dp[nums.length  - 1] = 1;
         int maxLIS = 1;

         for(int i = nums.length - 2; i >= 0 ; i--){
             int current = nums[i];
             int longest = 1;
             for(int k = i + 1; k < nums.length; k++){
                 if(nums[k] > current){
                     longest = Math.max(longest, dp[k] + 1);
                 }
             }
             dp[i] = longest;
             maxLIS = Math.max(maxLIS, dp[i]);
         }
         return maxLIS;
     }

    //O(n * n) DP using memoization solution
    // Time Complexity :O(n * n) -
    // Space Complexity :O(n) for the memo array
    // Did this code successfully run on Leetcode :yes
    // Any problem you faced while coding this :no
    public int lengthOfLISMemo(int[] nums) {
        if(nums == null){
            return 0;
        }
        int numberOfElements = nums.length;
        int[] memo = new int[numberOfElements];

        int max = dfs(nums, 0, memo);
        int LIS = 1;
        for(int i = 0; i < numberOfElements; i++){
            LIS = Math.max(LIS, memo[i]);
        }
        return LIS;
    }

    private int dfs(int[] nums, int idx,  int[] memo){
        //base
        if(idx == nums.length - 1){
            //memo[idx] = 1;
            return 1;
        }
        if(memo[idx] != 0){
            return memo[idx];
        }

        int maxLIS = 1;
        for(int childIdx = idx + 1; childIdx < nums.length; childIdx++){
            int childLIS = dfs(nums, childIdx, memo);
            if(nums[childIdx] > nums[idx]){
                maxLIS = Math.max(maxLIS, 1 + childLIS);
            }
        }
        memo[idx] = maxLIS;
        return memo[idx];
    }

}