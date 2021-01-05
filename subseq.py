#As taught in class, using DP to solve thus problem (increase if current and next number is in increasing order)
#Time complexity: O(n^2)
#Space complexity: O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums)==0:
            return 0
        dp = [1]*len(nums)
        m = 1
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i],dp[j]+1)
                    m = max(m,dp[i])
        return m
        