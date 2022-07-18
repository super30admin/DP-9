// Time Complexity : O(n*nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
used binary search method to place the number in the exact position of the sequence

 class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        int [] arr = new int[n];
        arr[0] = nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(arr[len-1] < nums[i]){
                arr[len] = nums[i];
                len++;
            }
            else{
                int bsindex = Bsearch(arr,nums[i],0,len-1);
                arr[bsindex] = nums[i];
            }
        }
        return len;
    }
    private int Bsearch(int []arr,int target,int low,int high){
        int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
