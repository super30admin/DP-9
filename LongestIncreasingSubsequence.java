// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We maintain an effective array that contains the length of the maximum subsequence thus calculated and only holds useful elements
// 2: If we can extend the maximum subsequence, we add to the effective array, else replace the element using Binary Search
// 3: Once we have iterated through the main array, we return the length of the effective array
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int idx = 0; // index on the effective array

        for(int i = 1; i<n; i++){
            if(nums[i] > arr[idx]){
                arr[idx+1] = nums[i];
                idx++;
            }
            else{
                // replace element in effective array
                int bsIdx = binarySearch(arr, 0, idx, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return idx+1;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = (low) + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}