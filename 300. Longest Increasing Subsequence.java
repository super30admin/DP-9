//300. Longest Increasing Subsequence.java
//##Problem ##152 : Length of Longest Increasing Subsequence
//Time Complexity(nlogn)
//space:O(n)
//https://github.com/super30admin/DP-9
//https://www.thesuper30.com/problem/5d8f084565d07400049429c3



class Solution {
    public int lengthOfLIS(int[] nums) {
        //edge case
        if(nums.length == 0 || nums == null)
            return 0;
        int n = nums.length;
        int dp[] = new int[n];
        int len = 0;
        dp[len++] = nums[0];
        
        int max = 1;
        for(int current = 1; current < n; ++current){
            //check if current is greater than the largest fom dp  
            if(nums[current] > dp[len-1]){
                dp[len++] = nums[current];               
            }
            else{
                int index = binSearch(dp,0,len-1,nums[current]);
                dp[index] = nums[current];  
            }     
        }
        return len;
    }
    
    private int binSearch(int[] dp, int low, int high, int target){
        
        while(low <= high){
            int mid = low + (high - low)/2;     
            if(dp[mid] == target) return mid;
            else if(dp[mid] > target) high = mid-1;
            else low = mid + 1;
        }
        return low;
    }
}
