// Time Complexity :
            /*           APPROACH 1 : USE DP : O(n^2) where n is the number of elements in nums array
                         APPROACH 2: USE BINARY SEARCH: O(nlogk) where n is the number of elements in nums array and k is the length of dp array at every instance
// Space Complexity : O(n) for dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: As you proceed with the array, store the number greater than previous ith number so that
it is an increasing sequence. if it is an increasing sewuence, store the max length of the sequence in dp[j] by adding the 1 to dp[i]. dp[i] stores
the max length of the sequence we have got till the ith instance. Keep a max to store the max length of the subsequence as we proceed and display
the max as the result.
*/
// APPROACH 1 : USE DP
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums  == null || nums.length ==0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);                                                                                     // Fill the DP array with 1
        int i  = 0, j = 1, max = 1;
        while(j < dp.length){                   
            i = 0;
            while(i < j){
            if(nums[j] > nums[i]){                                                          // If the number is in a increasing sequence
                dp[j] = Math.max(dp[j], dp[i] + 1);                                             // Store the max length, add 1 to the length we got at dp[i]
                max = Math.max(max, dp[j]);                                                     // Keep the max length
            } 
            i++;
            }
            j++;  
        }
        return max;                                                                             // return LCS
    }
}

// APPROACH 2 : BINARY SEARCH
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums  == null || nums.length ==0) return 0;
        int[] dp = new int[nums.length];
        int  j = 1;
        dp[0] = nums[0];                                                                                // Store the first element of nums
        for(int i = 1; i < nums.length; i++){
            if(dp[j-1] > nums[i]){                                                                      // Check if the latest number in dp is greater than nums
                int index = BinarySearch(dp, nums[i], j-1);
                dp[index] = nums[i];                                                                    // Replace the larger number with a nums[i] number prioritising the length of the sequence
            } else {
                if(nums[i] > dp[j-1])
                dp[j++] = nums[i];                                                                      // If the number is greater than the latest, store it in the next index
            }
        }
        return j;
    }
    private int BinarySearch(int[] dp, int x, int e){                                                   // Standard Binary Search function 
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