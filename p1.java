// Time Complexity : O(nlog(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 1;
        res[0] = nums[0];
//Go through all the elements
        for(int i=1; i<nums.length; i++){
            //If it's in increasing order, add the element to result array
            if(nums[i] > res[len-1]){
                res[len] = nums[i];
                len++;
            } else{
                //If it's not in increasing order, find the index which needs to be replaced
                int ind = search(res, 0 , len-1, nums[i]);
                res[ind] = nums[i];
            }
        }

        return len;
    }

//Function for binary search
    private int search(int[] res, int l, int r, int target){
        

        while(l <= r){
            int mid = l + (r-l)/2;
            if(res[mid] == target){
                return mid;
            }
            else if(res[mid] > target){
                r= mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return l;
    }
}