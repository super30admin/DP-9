// Time Complexity : O(N Log N)
// Space Complexity : O(1) reusing nums array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int len=0;
        nums[len++]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[len-1]<nums[i]){
                nums[len++]=nums[i];
            }else{
                int index = bs(nums,nums[i],len-1);
                nums[index]=nums[i];
            }
        }

        return len;
    }
    
    public int bs(int[] nums,int val,int len) {
        int left = 0,right=len;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==val)
                return mid;
            if(nums[mid]>val)
                right=mid-1;
            else
                left=mid+1;
        }
        
        return left;
    }
}
