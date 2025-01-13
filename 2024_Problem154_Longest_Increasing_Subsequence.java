//300. Longest Increasing Subsequence - https://leetcode.com/problems/longest-increasing-subsequence/description/
//Time Complexity: O(n^2)
//Space Complexity: O(n) ~ dp array

class Solution {
    public int lengthOfLIS(int[] nums) {
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        //minimum longest increasing subsequence by itself
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = 1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

//Time Complexity: O(n * log(n))
//Space Complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int len=1;

        for(int i=1; i<n; i++){
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            } else{
                //identify just greater element to replace
                int bsIndex = binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIndex] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid= low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
}

