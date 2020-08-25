//time complexity O(n^2)
//space complexity O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

//time complexity O(nlogn)
//space complexity O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] arr = new int[nums.length];
        int len = 0;
        arr[len++] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(arr[len-1] < nums[i]){
                arr[len++] = nums[i];
            } else {
                int idx = binarySearch(arr, 0, len - 1, nums[i]);
                arr[idx] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
