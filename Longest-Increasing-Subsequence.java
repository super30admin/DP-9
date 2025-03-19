## Problem1: Longest Increasing Subsequence (https://leetcode.com/problems/longest-increasing-subsequence/)


Time Complexity : O(n^2)
Sapce Complexity : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums== null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}


//Binary search approach
Time Complexity : O(n log n)
Space Complexity : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums== null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int max = 1;
        int[] result = new int[n];
        int length=1;
        result[0]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] > result[length-1]){
                result[length] = nums[i];
                length++;
            }
            else{
                int large = binarySearch(0,length-1,nums[i],result);
                result[large] = nums[i];
            }
        }
        return length;
    }
    private int binarySearch(int low,int high, int target, int[] nums){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                low=mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}