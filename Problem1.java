
// Time Complexity: O(n^2)
// Space Complexity: O(n)

// Did this code successfully run on Leetcode : Yes

//We use dp array to store the length of longest increasing subsequence ending at each index.
// We iterate through the array and for each element, we check all previous elements to see if we can extend the increasing subsequence.
// If we can, we update the dp array accordingly. Finally, we return the maximum value from the dp array.



class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int maxi=1;
        for(int len : dp){
            maxi=Math.max(maxi,len);
        }
        return maxi;
    }
}