//TC = O(n*n) for dp approach, O(nlogn) for dp with binary search approach
//SC = O(n)
//Solution executed successfully on LeetCode: yes

package com.madhurima;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
}

class LongestIncreasingSubsequenceDP {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);

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


class LongestIncreasingSubsequenceDPnBinarySearch {

    //usign dp and binary search
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] > dp[len-1]){
                dp[len] = nums[i];
                len++;
            }else{
                int index = binarySearch(dp, 0, len-1, nums[i]); //find number which is just greater than nums[i]
                dp[index] = nums[i];
            }
        }

        return len;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2; //to prevent integer overflow
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }
}
