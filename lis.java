// TC:Onlogn
//sc:O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] arr = new int[nums.length];
        arr[0]=nums[0];
        int le=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>arr[le-1]){
                arr[le]=nums[i];
                le++;
            }else{
                int bsIdx = binarySearch(arr,0,le-1,nums[i]);
                arr[bsIdx]=nums[i];
            }
        }
        return le;
    }

    private int binarySearch(int[]arr, int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}