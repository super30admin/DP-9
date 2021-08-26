// Time Complexity : O(n log n)
// Space Complexity : O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] arr = new int[nums.length];
        int l = 1;
        arr[0] = nums[0];
        
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <=  arr[l - 1]){
                int bsI = bsIndex(arr, 0, l - 1, nums[i]); 
                arr[bsI] = nums[i];
            }
            else{
                arr[l] = nums[i];
                l++;
            }
        }
        return l;
    }
    
    private int bsIndex(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            else if(target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}