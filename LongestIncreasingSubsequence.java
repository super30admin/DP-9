// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We can solve this problem by maintaining an effective longest increasing subsequence array where we only count the increasing
// subsequence elements. It might not give the correct subsequence but the length will be correct as we maintain them in an array. We start
// by inserting first element of nums array to the arr and then compare each of the nums element with the curr element in arr. If nums element
// is greater we add to arr, else find the next greater element in arr and replace it. The size of arr gives the longest increasing subsequence
// count.

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n]; //effective longest increasing subsequence array
        arr[0] = nums[0];
        int curr = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] > arr[curr]){ //if incoming is greater
                arr[curr+1] = nums[i]; //add to array
                curr++;
            } else{
                int pos = binarySearch(arr, 0, curr, nums[i]); //replace the next greater value than nums[i]
                arr[pos] = nums[i];
            }
        }
        return curr + 1;
    }

    private int binarySearch(int[] arr,int low,int high,int target){ //binary search
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target > arr[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}