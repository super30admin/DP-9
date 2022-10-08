//O(NlogN) space and time complexity. 

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n ==1) return 1;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int max =1;
        for(int i=1;i<n;i++){
            if (nums[i]<arr[max-1]){
                //do a binary serach in arr to find the number just greater than nums[i]
                int bsIdx = binarySearch(arr, 0, max-1, nums[i]);
                arr[bsIdx] = nums[i]; 
            }else if(nums[i]>arr[max-1]){
                arr[max] = nums[i];
                max++;
            }
        }
        return max;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if (arr[mid] < target){
                low = mid+1;
            }else high = mid-1;
        }
        return low;
    }
}
