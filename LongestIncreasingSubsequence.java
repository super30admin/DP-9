// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Mainatin an array (arr) for effective increasing subsequence. Initially has one element - first element in nums
/// Now iterate through nums array - if incoming element is > last element in arr add it to arr, else find the next greater element
/// to incoming element in arr. At the end return length of arr

class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        int le = 1;
        arr[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(arr[le-1] < nums[i])
            {
                arr[le] = nums[i];
                le++;
            }
            else
            {
                int idx = binarySearch(arr, 0 ,le, nums[i]);
                arr[idx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int arr[], int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}