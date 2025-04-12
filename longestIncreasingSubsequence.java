// Problem1: Longest Increasing Subsequence (https://leetcode.com/problems/longest-increasing-subsequence/)

// Time Complexity : O(nlogn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take an array of size n and take arr[0] = nums[0] and le = 1 its the effective idx. While traversing along the nums if nums[i]>arr[le-1]
 * then take arr[le] = nums[i] else replace the number just greater than nums[i]. Finally return le.
 */
// 1
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
//2
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []arr = new int[n];
        int le = 1; // idx of effective subsequence
        arr[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] > arr[le-1]){
                arr[le] = nums[i];
                le++;
            }
            else{
                //replace the num just greater than nums[i] in effective subsequence
                int idx = binarySearch(arr, 0, le-1, nums[i]);
                arr[idx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int []arr, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}