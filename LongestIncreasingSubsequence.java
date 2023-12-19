// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //print all lists
        /*brute force choose/not 2^n
        dp arr & 2 loops
        if nums[i] > nms[j] => dp[i] = dp[j]
        return max of dp[]*/

            int n = nums.length;
            if(n == 0 || nums == null)
                return 0;

        /*Effective Increasing Subsequence array with Binary Search
        Aux arr : compare incoming nums ele with the last ele in aux arr
        if it is greater add to arr
        else BS ele that is just greater than the incoming ele and replace it
        at the end length of aux arr is answer*/

            int[] arr = new int[n];
            arr[0] = nums[0];
            int len = 1;
            for(int  i = 1; i < n; i++){
                if(nums[i] > arr[len - 1]){
                    arr[len] = nums[i];
                    len++;
                }
                else{
                    int bsIdx = binarySearch(arr, 0, len-1, nums[i]);
                    arr[bsIdx] = nums[i];
                }
            }
            return len;
        }

        private int binarySearch(int[] arr, int l, int h, int target){
            while(l <= h){
                int mid = l + (h - l) / 2;
                if(arr[mid] == target){
                    return mid;
                }
                else if(arr[mid] > target){
                    h = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
