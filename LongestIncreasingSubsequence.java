/*
The time compleixity is O(N^2) and the space complexity is O(N) where N is the number of elements in the nums array.

Here, to avoid computing the subproblem again and again we can use an array where at each index i, the value will be longest increasing
subsequence from start to i. Get the max from the array.

Yes, the solution passed all the test cases.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;

        if(len==0){return 0;}

        //Store the subproblems.
        int[] dp = new int[len];
        Arrays.fill(dp,1);

        //max is used to store the max seen till now
        int max = 1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){

                //If num at i is greater than num at j. Then this can be included into the prev longest subsequence till j.
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max){
                        max = dp[i];
                    }
                }
            }
        }

        return max;
    }
}