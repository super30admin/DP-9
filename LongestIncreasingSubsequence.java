// Time Complexity : Exponential O(2^N) N:length of given sequence
// Space Complexity : O(N) recursive stack size
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : 
 /* 
 Bruteforce:
 1. Taken all possible sequences 2^N through recursion
 2. Remember to pass the prev value in function to check the next index taken or not
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        return helper(nums, Integer.MIN_VALUE, 0); // Initially prev value is min, so that it will be compared with 0th index.
    }
    
    private int helper(int[] nums, int prev, int index){
        //base
        if(index == nums.length) return 0; //visted all possible indexes, out of bound so return 0;
        
        //Taking
        int taken = 0;
        if(nums[index] > prev){
            taken = 1 + helper(nums, nums[index], index+1);
        }
        //Not Taking
        int not_taken = helper(nums, prev, index+1);
        
        return Math.max(taken, not_taken);
    }
}




// Time Complexity : Exponential O(N*N) N:length of given sequence
// Space Complexity : O(N) DP array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
 /* 
 DP: 
 1. For every index, check with all indexes possible till that index (0 -> i-1); => LIS till that index.
 2. When satisfied, update the values by using the jth index value.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1; //min length wouyld be 1
        for(int i =1; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}




// Time Complexity : Exponential O(N*logN) N:length of given sequence
// Space Complexity : O(N) DP array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
 /* 
 BS: 
 1. For every element of main array, place it in the right position of dp array.
 2. Now the length of dp array will give the LIS length.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        dp[len++] = nums[0];
        for(int i =1; i<nums.length; i++){
            if(dp[len-1] < nums[i]){
                  dp[len++] = nums[i]; 
            }
            else{
                int idx = BinarySearch(dp, 0, len-1, nums[i]); // to find index of element just higher than current nums[i] in dp 
                dp[idx] = nums[i];
            }
        }
        return len;
    }
    
    private int BinarySearch(int[] a, int low, int high, int target){
        while(low<high){
            int mid = low + (high-low)/2;
            if(a[mid] >= target){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}

