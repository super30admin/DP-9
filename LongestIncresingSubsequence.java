
class Solution {
    //Time Complexity:(n)
    //Space Complexity:(n)
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int [nums.length];

        dp[0] = nums[0];
        int len =1;
        for (int i =1; i < nums.length;i++){
            if (nums[i] > dp [len-1]){
               dp [len] = nums[i];
               len++; 
            } else{
        //we're getting a smaller number, we'll look for a number that is just bigger
            int bIndex = bSearch (dp, 0, len, nums[i]);
            dp[bIndex] = nums[i];
            }
        }
        return len;
    }
        
        private int  bSearch (int[] nums, int start, int end, int target){
            
            while (start <= end){
                int mid = start + (end-start)/2;
                if (nums[mid] == target){
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
            return start;
        }
    }
