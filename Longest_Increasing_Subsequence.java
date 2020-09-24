
class Longest_Increasing_Subsequence_DP {
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0)
			return nums.length;

		int[] dp = new int[nums.length];   
		int max = 0;
		//Initialize the Length of longest Increasing Subsequence(dp) values for all indexes as 1
		for(int i=0; i<dp.length; i++)
			dp[i] = 1;

		//nums = {3, 10, 2, 11}
		//i = 1, j = 0 => (10 > 3 and 1 <= 1) => dp[1,2,1,1]
		//i = 2, j = 0 => (2 is not greater than 3, so no change)  => dp[1,2,1,1]
		//i = 2, j = 1 => (2 is not greater than 10, so no change) => dp[1,2,1,1]
		//i = 3, j = 0 => (11 > 3 and 1 <= 1) => dp[1,2,1,2]
		//i = 3, j = 1 => (11 > 10 and 2 <= 2) => dp[1,2,1,3]
		//i = 3, j = 2 => (11 > 2 and 3 is greater than 1, so no change) => dp[1,2,1,3]

		for(int i=1; i<nums.length; i++){   
			for(int j=0; j<i; j++){
				if(nums[i] > nums[j] && dp[i] <= dp[j]){
					dp[i] = dp[j] + 1;
				}
			}
		}
		for(int i=0; i< nums.length; i++){
			if(max < dp[i])
				max = dp[i];
		}
		return max;
	}
}
