class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int [] arr = new int[nums.length];
        arr[0] = nums[0];
        int len = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > arr[len - 1]){
                arr[len] = nums[i];
                len++;
            }else{
                int bsIndex  = binarySearch(arr, 0, len -1, nums[i]);
                arr[bsIndex] = nums[i];
            }
        }
        return len;
        
    }
    
    private int binarySearch(int [] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] >target) high = mid -1 ;
            else low = mid + 1;
        }
        return low;
    }
}

//TC: O n (log n)
//SC: O(n)
