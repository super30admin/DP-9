class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # Time: O(n^2)
        # Space: O(n)
        dp = [1 for i in range(0,len(nums))]
        for i in range(1,len(nums)):
            for j in range(0,i):
                if(nums[j]<nums[i] and dp[i]<1+dp[j]):
                    dp[i] = 1 + dp[j]
        return max(dp)
