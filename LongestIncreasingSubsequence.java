// Time Complexity :O(n log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] arr=new int[nums.length];
        arr[0]=nums[0];
        int len=1;        
        int max=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>arr[len-1]){
                arr[len]=nums[i];
                len++;
            }else{
                int bIndex=binarySearch(arr,0,len-1,nums[i]);
                arr[bIndex] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
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