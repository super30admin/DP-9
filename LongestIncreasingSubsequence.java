
class LongestIncreasingSubsequence {
    
    // Time complexity - O(n^2)
    // Space complexity - O(n)
    // Tested in leetcode
    
    // Approch 1 - Dynamic programming
    //Allocate an array to store the solution of subproblem.
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int gmax = 1;
        
        // loop through the array and find out the maximum length till the current index. Return maximum length.
        for(int i = nums.length-2; i>=0 ; i--){
            int max = 1;
            for(int j = i+1; j<nums.length ; j++){
                if(nums[j] > nums[i]){
                    max = Math.max(max,dp[j] + 1);
                }
            }
            dp[i] = max;
            gmax= Math.max(max,gmax);
        }
        return gmax;
    }
    
     // Time complexity - O(2^n)
    // Space complexity - O(n)
    // TLE
    
    // Approch 1 - Recursion 
    // Driver function call helper function to recurse through each posibility of the solution.
    
    public int lengthOfLIS1(int[] nums) {
        return helper(nums,Integer.MIN_VALUE, 0);
    }
    
    public int helper(int[] nums, int min, int index){
        if(index == nums.length)
            return 0;
         
        int select = 0, notSelect =0;
        
        if(min < nums[index])
            select = 1 + helper(nums,nums[index],index+1);
        notSelect = helper(nums,min,index+1);
      
        return Math.max(select,notSelect);

    }
}




