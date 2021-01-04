# DP Approach
# Time Complexity: O(n^2)
# Space Complexity: O(n)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Initialize a dp array with 1's - dp[i] indicates the length of the longest subsequence at index i
        dp = [1 for _ in range(len(nums))]
        # initial maxlen = 1
        maxlen = 1

        # For every number at index i, scan numbers from 0 to i-1 and see if they form an increasing subsequence with the number at index i
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    # the number at index j forms an increasing subsequence with i
                    # update dp[i] to include the number at j if it results in a better/longer subsequence
                    dp[i] = max(dp[i], dp[j]+1)
                    # Update maxlen
                    maxlen = max(maxlen, dp[i])

        return maxlen
