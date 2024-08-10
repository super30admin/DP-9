// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int  result[] = new int[n];
        result[0] = nums[0];
        int len = 1;
        
        for(int i = 1; i < n; i++){
            if(nums[i] > result[len-1]){
                result[len] = nums[i];
                len++;
            }
            else{
                int index = bSearch(result, 0, len-1, nums[i]);
                result[index] = nums[i];
            }
        }
        return len;
    }
    private int bSearch(int[] nums, int low, int high, int target){
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}