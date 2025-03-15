//TC: O(n^2)
//SC: O(n)
//approach: dynamic programming

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max =1;
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

//TC: O(n logn)
    //SC: O(n)
    //approach: optimized dynamic programming

    public int lengthOfLISOptimized(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int length = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>res[length-1]){
                res[length] = nums[i];
                length++;
            }else{
                int bsIdx = binarySearch(res, 0,length-1,nums[i]);
                res[bsIdx] = nums[i];
            }

        }
        return length;
    }

    private int binarySearch(int[] result, int start, int end, int val){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(result[mid]==val){
                return mid;
            }else if(result[mid] < val){
                start = mid+1;
            }else end = mid-1;
        }
        return start;
    }
}
