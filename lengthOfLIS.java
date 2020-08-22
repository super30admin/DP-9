//Time - O(n log n)
//Space - O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        //int max = 1;
        int[] arr = new int[nums.length];
        int len = 0;
        arr[len++] = nums[0];
        //Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>arr[len-1]){
                arr[len++]=nums[i];
            }else{
                int idx = binSearch(arr,0,len-1,nums[i]);
                arr[idx] = nums[i];
            }
        }
        return len;
    }
    
    private int binSearch(int[] nums , int left, int right,int target){
        while(left<=right){
            
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
