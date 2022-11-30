class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 1
        n = len(nums)

        dp = [1] * n
        m = 1
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    m = max(m, dp[i])

        # print(dp)
        return m

# Dynamic Programming
# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
