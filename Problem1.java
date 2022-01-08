// 300 Longest increasing subsequence
// time - O(nlogn)
// space - O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int curr = 0;
        
        dp[0] = nums[0];
         curr++;
        
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] > dp[curr - 1]){
                dp[curr] = nums[i];
                curr++;
            }else{
                
                int searchIndex = binarySearch(dp, nums[i], curr);
                
                dp[searchIndex] = nums[i];
            }
        }
        
        return curr;
    }
    
    private int binarySearch(int[] nums, int target, int size){
        
        int low = 0;
        int high = size - 1;
        int mid = 0;
        
        while(low <= high){
            
            mid = (low + high)/2;
            
            if(nums[mid] == target){
                
                return mid;
                
            }else if(nums[mid] > target)
            {
                high = mid - 1;
            }else
            {
                low = mid + 1;
            }
        }
        
        return low;
    }
        

}