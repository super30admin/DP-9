class Solution {
    public int lengthOfLIS(int[] nums) {
         //base case
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        //Initialize dp array and fillit with all 1's
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int max = 0;
        
        //for each element i, check all valid previous number pairs and update the dp with max value
        //update max at each level
        for(int i = 0; i < nums.length; i++){
            int ans = dp[i];
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                   ans = Math.max(ans, dp[i]+dp[j]);
                }
            }
            dp[i] = ans;
            max = Math.max(max, ans);
        }
        
        return max;
    }
}

//Time Complexity: O(n^2)
//Space Complexity:O(n)