//TC : O(nLogn)
//SC : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for(int i=1;i<n;i++)
        {
            if(nums[i]>dp[len-1])
            {
                dp[len] = nums[i];
                len++;
            }
            else
            {
                int biIndex = binarySearch(dp,0,len-1,nums[i]);
                dp[biIndex] = nums[i];
            }
        }
        return len;
    }

    public int binarySearch(int[] dp,int low,int high, int target){
        while(high>=low){
            int mid = low+(high-low)/2;

            if(dp[mid] == target)
                return mid;
            else if(dp[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}