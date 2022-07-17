// Time: O(N^2) | Space: O(N)

//brute force
class Solution {
    public int lengthOfLIS(int[] nums) {
        // maintaining dp matrix with longest substring at every element
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(dp[i], max);
        }
        return max+1;
    }
}

//Time: O(NLogN) | Space: O(N)
// optimised soln
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] effectiveArr = new int[nums.length];
        effectiveArr[0] = nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++) {
            if(effectiveArr[len-1] < nums[i]) {
                // if there's no max to curr element, add it to the array
                effectiveArr[len] = nums[i];
                len++;
            } else {
                // we compare the nearest max to our curr element
                // replace
                int bsIndex = binarySearch(effectiveArr, nums[i], 0, len-1);
                effectiveArr[bsIndex] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int target, int low, int high) {
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) low = mid+1;
            else high = mid -1;
        }
        return low;
    }
}