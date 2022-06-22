// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    
    public int lengthOfLIS(int[] nums) {
    
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        
        int length = 1;
        int[] arr = new int[n];
        arr[0] = nums[0];
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > arr[length - 1]) {
                arr[length++] = nums[i];
            } else {
                int index = search(arr, 0, length - 1, nums[i]);
                arr[index] = nums[i];
            }
        }
        
        return length;
    }
    
    private int search(int[] arr, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}