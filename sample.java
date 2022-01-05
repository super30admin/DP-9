// lis
//tc n square
//sc n
class Solution {
    
    int gmax = 1;
    
    public int lengthOfLIS(int[] nums) {
        
        Integer[] dp = new Integer[nums.length];
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        
        // memoization
//         for(int i = 0; i < nums.length; i++){
            
//             gmax = Math.max(gmax, helper(nums, i, dp));
            
//         }
        // return gmax;
        
        for(int i = 1; i < nums.length; i++){
            
            for(int j = 0; j < i; j++){
                
                if(nums[i] > nums[j]){
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    gmax = Math.max(gmax, dp[i]);
                }
                
            }
            
        }
        
        return gmax;
    }
    
    // recursion with memoization
    private int helper(int[] nums, int index, Integer[] dp){
        
        int max = 0;
        
        //base
        if(index == nums.length) return 0;
        
        if(dp[index] != null) return dp[index];
        
        //logic
            for(int j = index+1; j < nums.length; j++){
            
            if(nums[j] > nums[index]){
              
                max = Math.max(max, helper(nums, j, dp));  
            }
        }
        
        dp[index] = max + 1; // memoize
        
        return max + 1;
        
    }
}

//russian doll
//tc n square
//sc n
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int gmax = 1;
        
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] - b[0];
        });
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < dp.length; i++){
            
            for(int j = 0; j < i; j++){
                
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    gmax = Math.max(gmax, dp[i]);
                }
                
            }
        }
        return gmax;
    }
}
