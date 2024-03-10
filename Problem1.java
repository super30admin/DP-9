class Solution {
    //TC: O(nlogn)
    //SC: O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n]; //effective increasing
        int len = 1;
        arr[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] > arr[len - 1]){
                arr[len] = nums[i];
                len++;
            }else{
                int bstIndex = binarySearch(arr,0,len-1,nums[i]);
                arr[bstIndex] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int [] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
