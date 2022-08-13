//TC - O(n* log n)
//Sc - O(n)
class Solution {
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
            }else{
                int bsIndex = binarySearch(arr, 0, len - 1, nums[i]);
                arr[bsIndex] = nums[i];
            }
        }
        return len;
        
    }
    private int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}
