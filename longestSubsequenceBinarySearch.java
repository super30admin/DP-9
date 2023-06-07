//TC: O(nlogn)
//SC: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] effectiveArray = new int[n];
        effectiveArray[0] = nums[0];
        int len = 1;
        
        for(int i=1;i<n;i++){
            if(nums[i] > effectiveArray[len-1]){
                effectiveArray[len] = nums[i];
                len++;
            }else{
                //do binary search and find just greate ele and put it at correct place
                int bsIndex = binarySearch(effectiveArray, 0, len-1, nums[i]);
                effectiveArray[bsIndex] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
