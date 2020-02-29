TC: O(n^2)
SC: O(n)

Runtime: 9 ms, faster than 65.63% of Java online submissions for Longest Increasing Subsequence.
Memory Usage: 37.8 MB, less than 32.00% of Java online submissions for Longest Increasing Subsequence.

Approach : Using a dp approach we can find the solution. We will calculate for each index the max length of subsequence till that index 
and save it in a dp array.For each index, we will find the the maximum subsequence till that index in the dp array and add 1 to it.We 
will repeat the same for indexes coming after this.


class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1 ) return 1;
        int dp[]= new int[nums.length];
        
        
        Arrays.fill(dp,1);
        int totalmax = 0;
        for(int i=1; i< nums.length; i++){
        int max= 0;
        
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    max= Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
            totalmax = Math.max(dp[i],totalmax);
        }
        return totalmax;
                
        
    }
}

