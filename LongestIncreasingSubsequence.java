//Binary Search
// Time Complexity: O(n logn)
// Space Complexity :o(1)

/*
 * here we traverse through the array and if the element is greater
 * than the last greatest value in the sequence then add it and increment index.
 * else add the element to its correct position in the sequence.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length;
        int len = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[len-1]){
                nums[len] = nums[i];
                len++;
            }
            else{
                int binary = binarySearch(nums, 0, len-1, nums[i]);
                nums[binary] = nums[i];
            }
        }
        return len;
    }

    public int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

//DP
// Time Complexity: O(n^2)
// Space Complexity :o(n)

/*
 * here we traverse through the array and keep a second pointer which
 * tracks the max subsequence with that element. and return the max
 * length of the subsequence at the end.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = dp[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}