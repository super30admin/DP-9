class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        dp = [1 for i in range(len(nums))]

        max_len = 1

        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    max_len = max(dp[i], max_len)
        return max_len

