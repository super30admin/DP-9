import java.util.Arrays;
// DP Solution
// TC : O(n2)
// SC : O(n)
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1; i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            } 
        }
        return max;
    }
}



//Binary Search Solution
// TC: O(nlogn)
// SC: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] effectiveNums = new int[n];
        int length = 1;
        effectiveNums[0] = nums[0];
        for(int i=1;i<n;i++) {
            if(nums[i] > effectiveNums[length-1]) {
                effectiveNums[length++] = nums[i];
            } else {
                int bsIdx = binarySearch(effectiveNums, 0, length, nums[i]);
                effectiveNums[bsIdx] = nums[i];
            }
        }
        return length;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low < high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid;
            else low = mid+1;
        }
        return low;
    }
}