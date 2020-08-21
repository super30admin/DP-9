//Time complexity: O(nlogn)
//Space complexity:O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int len = 0;
        int[] arr=new int[nums.length];
        arr[len++]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(arr[len-1]<nums[i]){
                arr[len++]=nums[i];
            }else{
                int idx=binarysearch(arr,0,len-1,nums[i]);
                arr[idx]=nums[i];
            }
        }
        return len;
    }   
    
    private int binarysearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}