class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int [] arr = new int [n];
        arr[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++){
            if(nums[i] > arr[len - 1]){
                arr[len] = nums[i];
                len++;
            }else{
                int idx = BinarySearch(arr, 0, len - 1, nums[i]);
                arr[idx] = nums[i];
            }
        }
        return len;
    }
    
    private int BinarySearch(int [] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
         }
        return low;
    }
}
