# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        dp = ([1] * len(nums))
        for i in range(1, len(nums)):
            for j in range(i):
                if (nums[j] < nums[i]):
                    dp[i] = max(dp[i], (dp[j] + 1))
        return max(dp)