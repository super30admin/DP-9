#Time: O(N^2)
#Space: O(N)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums == None or len(nums)==0:
            return 0

        dp = [1]*len(nums)
        for i in range(1,len(nums)):
            for j in range(0, i):
                if nums[i]>nums[j]:
                    dp[i] = max(dp[i], 1+dp[j])

        return max(dp)
