// Time Complexity : DP: O(n^2) , Binary Search: O(nlogk) k = length of dp array at every instance
// Space Complexity : O(n) for dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Using DP
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int i=0,j=1,max = 1;
        while(j < dp.length) {
            i=0;
            while(i<j) {
                if(nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j],dp[i]+1);
                    max = Math.max(max,dp[j]);
                }
                i++;
            }
            j++;
        }
        return max;
    }
}

// DP using Binary Search

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int j=1;
        dp[0] = nums[0]; // store first element of nums
        for(int i=1;i<nums.length;i++) {
            if(dp[j-1] > nums[i]) { // check if latest num in dp is greater than nums
                int idx = BinarySearch(dp,nums[i],j-1);
                dp[idx] = nums[i]; // replace larger num with nums[i] prioritising the length of sequence
            } else {
                if(nums[i] > dp[j-1]) // num greater than latest -> store it in next idx
                    dp[j++] = nums[i];
            }
        }
        return j;
    }
    private int BinarySearch(int[] dp, int x, int e){                                                 
        int i =0, j = e;
        while(i <= j){
            int mid =  i + (j-i)/2;
            if(dp[mid] == x){
                return mid;
            } else
            if(dp[mid] > x){
                j = mid -1;
            } else {
                i = mid + 1;
            }
        }
        return i;
        }
}