// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i< n;i++){
            for(int j =0;j < i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}


// Time Complexity : O(N LOG N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;

        int[] arr = new int[n];
        arr[0]= nums[0];

        int len =1;

        for(int i=1;i<n;i++){
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }else{
                int bsIndex = binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIndex] = nums[i];
            }
        }

        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target ){

        while(low <= high) {
            int mid = low +(high-low)/2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] >= target){
                high = mid -1;
            }else{
                low = mid+1;
            }

        }

        return low;
    }
}