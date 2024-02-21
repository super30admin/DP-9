// Time Complexity:  O(nlogn)
// Space Complexity: O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int len = 1;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > arr[len-1]) {
                arr[len] = nums[i];
                len++;
            }
            else {
                int binaryIndex = binarySearch(arr, 0, len, nums[i]);
                arr[binaryIndex] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}




// Time Complexity:  O(n^2)
// Space Complexity: O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[i] = Math.max(dp[i], 1 + dp[j]));
                }
            }
        }
        return maxLen;
    }
}
