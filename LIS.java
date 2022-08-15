// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1)
            return 1;
        
        int[] subList = new int[nums.length];
        int len = -1;
        
        for(int i=0; i<nums.length;i++) {
            if(len==-1 || nums[i] > subList[len]){
                subList[len+1] = nums[i];
                len++;
            }else{
                int index = binarysearch(subList, 0, len, nums[i]);
                subList[index] = nums[i];
            }
        }
        
        return len+1;
    }
    
    public int binarysearch(int[] subList, int low, int high, int target) {
        while(low<=high) {
            int mid = low+ (high-low)/2;
            if(subList[mid] == target)
                return mid;
            else if(subList[mid]>target) {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return low;
    }
}
