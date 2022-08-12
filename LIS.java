//Time: O(n^2)
//Space: O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        //null case check
        if(n == 0 || nums==null) return 0;
        
        //creating a dp array of size n
        int[] dp = new int[n];
        
        //filling the array with '1's as a digit on itself is an increasing subsequence
        Arrays.fill(dp, 1);
        
        //initializing the max length of increasing subsequence so far as '1'
        int max = 1;
        
        //initially placing pointers j and i at 0th and 1st index respectively
        //we will keep moving the i and checking all the subsequences forming between j and i
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                //if the element at ith index is greater than the element at jth index then 
                if(nums[i] > nums[j]) {
                    //we check if the max possible inc. subseq. at i is already greater than what it will be after incrementing j and we update it accordingly
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    
                    //updating max as we move forward with our iterations
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
