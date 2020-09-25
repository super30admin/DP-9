/****************************Using DP***********************************/
// Time Complexity :O(n^2), n is length of nums
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Longest_Increasing_Subsequence_DP1 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];   
        int max = 1;
         //Initialize the Length of longest Increasing Subsequence(dp) values for all indexes as 1
        for(int i=0; i<dp.length; i++)
            dp[i] = 1;
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    // it means i is forming a increasing subsequence with j
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }        
        return max;
    }
}

/**********************************************************************************************/
//Time Complexity :O(n^2), n is length of nums
//Space Complexity :O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no
class Longest_Increasing_Subsequence_DP {
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;

		int[] dp = new int[nums.length];   
		int max = 1;
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


/****************************Using Binary Search***********************************/
//Time Complexity :O(n log n), n is length of nums
//Space Complexity :O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

class Longest_Increasing_Subsequence_BS {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] arr = new int[nums.length];
        int len= 0;
        arr[len] = nums[0];
        len++;
        for(int i=1; i<nums.length; i++){
            //case1
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }
            else{
                //input is at its correct index, replace the just greater element
                int index = binarysearch(arr, 0, len, nums[i]);
                arr[index] = nums[i];
            }
        }
        return len;
    }
    private int binarysearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low; // low ptr is always at the just greater element
    }
}