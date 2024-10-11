// Problem 300. Longest Increasing Subsequence
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n]; // effective increasing subsequence
        arr[0] = nums[0];
        int l = 1;
        for(int i=1; i<n; i++){
            if(arr[l-1] < nums[i]){
                arr[l] = nums[i];
                l++;
            }else{
                int bsIdx = binarySearch(arr, 0, l-1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return l;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
