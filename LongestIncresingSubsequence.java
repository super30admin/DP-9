class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int left = 1;
        for(int i = 1; i < n; i++){
            if(arr[left-1] < nums[i]){
                arr[left] = nums[i];
                left++;
            }else{
                int bsIdx = binarySearch(arr, 0, left, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return left;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] > target){
                high = mid - 1;
            }else low = mid + 1;
        }
        return low;
    }
}
