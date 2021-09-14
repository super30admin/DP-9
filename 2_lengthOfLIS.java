// 300. Longest Increasing Subsequence : https://leetcode.com/problems/longest-increasing-subsequence/
// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int len = 1;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > arr[len-1]){
                arr[len++] = nums[i];
            }else{
                int bIndex = binarySearch(arr, nums[i], 0, len-1);
                arr[bIndex] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr, int target, int low, int high){
        while(low <= high) {
            int mid = low + (high - low) /2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid -1;
            } else {
                low = mid +1;
            }  
        }
        return low;
    }
}