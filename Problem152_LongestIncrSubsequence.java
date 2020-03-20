//Time Complexity: O(n^2)

public class Solution {
    public int lengthOfLIS(int[] nums) {
        //base case
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        int[] dp = new int[nums.length];
        //fill the array with 1 as a number itself 
        //is a longest individual subsequence
        Arrays.fill(dp,1);
        int maxans = 1;
        //array starts from j, j+1=i
        for (int i = 1; i < dp.length; i++) {     
            for (int j = 0; j < i; j++) {
                //if i > j; compare initial value of i with j+1
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //find max of all
                     maxans = Math.max(maxans, dp[i]);
                }
            }          
        }
        //return max of all
        return maxans;
    }
}