// Time Complexity : The time complexity is O(nlogn) where n is the length of array
// Space Complexity : The space complexity is O(n) where n is the length of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int index = 1;

        for(int i=1;i<n;i++){
            //if the current number forms an increasing sequence
            if(dp[index-1] < nums[i]){
                dp[index] = nums[i];
                index++;
            }
            // if the current number doesnt form an increasing sequence, do binary search to replace the closest next element
            else{
                int idx = binarySearch(dp,0,index-1,nums[i]);
                dp[idx] = nums[i];
            }
        }
        return index;
    }

    public int binarySearch(int[] nums,int start,int end,int target){

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}