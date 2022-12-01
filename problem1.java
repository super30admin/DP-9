package DP-9;

public class problem1 {
    class Solution {
        //TC:- O(nlogn)
        //SC:- O(n)
        public int lengthOfLIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            
            int n = nums.length;
            int[] arr = new int[n];
            
            arr[0] = nums[0];
            int len = 1;
            
            for(int i = 1; i < n; i++){
                if(nums[i] > arr[len - 1]){
                    arr[len] = nums[i];
                    len++;
                }
                else {
                    int idx = binarySearch(arr, nums[i], 0, len - 1);
                    arr[idx] = nums[i];
                }
            }
            
            return len;
        }
        
        private int binarySearch(int[] arr, int target, int low, int high){
            
            while(low <= high){
                
                int mid = low + (high - low) / 2;
                
                if(arr[mid] == target){
                    return mid;
                }
                else if(target < arr[mid]) {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            
            return low;
        }
    }
}
